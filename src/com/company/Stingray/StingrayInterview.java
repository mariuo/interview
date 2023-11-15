package com.company.Stingray;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class DispatcherInterview {

    /*
      Ceci est une implémentation naïve d'un système de "Job Dispatching".

      La classe Agent représente un node indépendant qui effectue des Job dans une thread.

      La class Dispatcher représente le serveur appelé par les Agent pour obtenir une Job.

      Les jobs fonctionnent avec un système de priorité. voir l'enum Priority, plus bas.

      En premier lieu, regardez l'implémentation de Dispatcher.setupDatabase().
      Vous constaterez que trois Job se font ajouter à la base de données en mémoire,
      suivi d'une 4e Job, de priorité REALTIME, qui est ajoutée 2 secondes plus tard.

      Exécutez le programme une première fois. Vous constaterez que la job de priorité REALTIME (La job #3) est exécutée en dernier.

      Mise en situation : Un client se plaint que ses Job, de priorité REALTIME, ne sont pas exécutées assez rapidement après avoir été créées.
                          Quel changement pourriez vous faire pour
                          satisfaire les besoins de votre client, tout en conservant :

                          1. Le même nombre d'Agent dans le pool (3)
                          2. La même séquence de création de Job
                          3. Le même système de 4 priorités

      */

    private static boolean detailedLogs = false;

    private static Dispatcher prepareDispatcher() {
        return new Dispatcher();
    }

    private Agent[] prepareAgents(Dispatcher d) {
        Agent agent1 = new Agent("1", d, true);
        Agent agent2 = new Agent("2", d, false);
        Agent agent3 = new Agent("3", d, false);

        return new Agent[]{agent1, agent2, agent3};
    }

    static class Agent extends BaseAgent {

        private Dispatcher dispatcher;
        private boolean isRealtime;

        Agent(String name, Dispatcher d, boolean isRealtime) {
            super(name);
            this.dispatcher = d;
            this.isRealtime = isRealtime;
        }

//        Agent(String name, Dispatcher d) {
//            super(name);
//            this.dispatcher = d;
//        }

        @Override
        // returns if the Agent executed a job or not
        protected boolean doExecute(){
//            Job job = dispatcher.getJob();
            Job job = dispatcher.getJob(isRealtime);
            if (job != null) {
                job.executeJob();
                return true;
            } else {
                return false;
            }
        }
    }

    static class Dispatcher extends BaseDispatcher {

        Dispatcher() {
            super();
        }

        public synchronized Job getJob(boolean isRealtime) {

            List<Job> jobs = getAvailableJobs().stream()
                    .sorted((j1, j2) -> j2.priority.ordinal() - j1.priority.ordinal()).collect(Collectors.toList());

            if (jobs.size() > 0) {
                Job dispatchedJob = jobs.get(0);
                if(!isRealtime && dispatchedJob.priority != Priority.REALTIME) {
                    //As soon as a job is served, we remove it from the TO-DO jobs
                    //Therefore, by contract an agent MUST execute the job it is given
                    removeFromAvailableJobs(dispatchedJob);
                    return dispatchedJob;
                }else if(isRealtime && dispatchedJob.priority == Priority.REALTIME){
                    removeFromAvailableJobs(dispatchedJob);
                    return dispatchedJob;
                }
            }

            //if no job is available, by contract with the agent we return null
            return null;
        }
    }

    /***** NE PAS TOUCHER *****

     Tout le code plus bas n'est pas modifiable pour les fins de l'exercice. Vous pouvez l'observer si vous le désirez.

     Il s'agit:
     - du code technique de synchronisation.
     - du code qui appartient à la mise en situation, qu'on ne veut pas modifier.

     */

    enum Priority {
        NORMAL, // Job d'importance normale
        HIGH, // Job Importante
        CRITICAL, // Job Critique
        REALTIME // Job la plus prioritaire, doit être exécutée immédiatement!
    }

    public static class Job {

        public static Job create(Long id, DispatcherInterview.Priority priority, int timeToExecuteMs) {
            return new Job(id, priority, timeToExecuteMs);
        }

        private Job(Long id, DispatcherInterview.Priority priority, int timeToExecuteMs) {
            this.id = id;
            this.priority = priority;
            this.timeToExecuteMs = timeToExecuteMs;
        }

        public void executeJob() {
            System.out.println(Thread.currentThread().getName() + ": Job #" + this.id + "(" + this.priority + ")" + " is executing for " + timeToExecuteMs + "...");
            try {
                Thread.sleep(timeToExecuteMs);
                completedJobs.add(this);
                if (completedJobs.size() == jobsCreated.get()){
                    endProgramLock.release();
                }
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + ": Job #" + this.id + " Interrupted.");
            }
            System.out.println(Thread.currentThread().getName() + ": Job #" + this.id + " Completed.");
        }

        public final Long id;
        public final DispatcherInterview.Priority priority;
        public final int timeToExecuteMs;
    }

    private static Semaphore endProgramLock = new Semaphore(0);
    private static Collection<Job> completedJobs = new ConcurrentLinkedQueue<>();
    private static AtomicInteger jobsCreated = new AtomicInteger(0);

    public static void main (String[] args) {
        System.out.println("Program Start");
        DispatcherInterview di = new DispatcherInterview();
        Dispatcher dispatcher = prepareDispatcher();
        Agent[] agents = di.prepareAgents(dispatcher);
        try {

            for(Agent agent : agents) {
                Thread.sleep(100);
                agent.start();
            }
            int elapsedMS = 0;
            boolean ended = false;
            while (elapsedMS < 10000 && !ended) {
                ended = endProgramLock.tryAcquire(500, TimeUnit.MILLISECONDS);
                if (!ended) {
                    if (detailedLogs) System.out.println("tick..");
                    elapsedMS += 500;
                }
            }
            if (!ended){
                System.out.println("10 second timeout attained.");
            } else {
                System.out.println("All jobs complete.");
            }
            for(Agent agent : agents) {
                Thread.sleep(100);
                agent.kill();
            }
            System.out.println("Program End");
        } catch (InterruptedException e) {
        }
    }

    static abstract class BaseDispatcher {

        BaseDispatcher() {
            setupDatabase();
        }

        protected void setupDatabase() {

            (new Thread(() -> {
                /*
                 * Cette thread simule un ajout d'une Job REALTIME, ajoutée à la base de données 2 secondes après les trois premières jobs.
                 *
                 */
                addJob(0L, Priority.NORMAL, 5000);
                addJob(1L, Priority.HIGH, 5000);
                addJob(2L, Priority.CRITICAL, 5000);


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}

                addJob(5L, Priority.REALTIME, 500);
            })).start();
        }

        private void addJob(long jobID, Priority priority, int executionTime) {
            System.out.println("Dispatcher: Job #" +jobID + " with priority " + priority + " was added.");
            jobsCreated.incrementAndGet();
            jobInMemoryDatabase.add(Job.create(jobID, priority, executionTime));
        }

        private List<Job> jobInMemoryDatabase = new CopyOnWriteArrayList<>();

        protected List<Job> getAvailableJobs() {
            return jobInMemoryDatabase;
        }

        protected void removeFromAvailableJobs(Job dispatchedJob) {
            jobInMemoryDatabase.remove(dispatchedJob);
        }
    }

    static abstract class BaseAgent {
        public BaseAgent(String name) {
            this.name = name;
        }

        private final String name;
        private AtomicBoolean kill = new AtomicBoolean(false);

        public void start() {
            (new Thread(() -> {
                while(!kill.get()) {
                    if (detailedLogs) System.out.println(Thread.currentThread().getName() + ": Looking for a job to execute...");
                    boolean workDone = doExecute();

                    if (!workDone) {
                        try {
                            if (detailedLogs) System.out.println(Thread.currentThread().getName() + ": No job found. Sleeping...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {}
                    }
                }
            },"Agent-" +name)).start();
        }
        protected abstract boolean doExecute();

        public void kill() {
            kill.set(true);
        }
    }


}