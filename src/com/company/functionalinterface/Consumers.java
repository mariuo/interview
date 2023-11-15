package com.company.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Consumers {

    public static void main(String[] args){
        List<Person> peaple = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alicia", Gender.FEMALE)
        );

        List<Person> females = new ArrayList<>();
        for(Person person : peaple){
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female : females){
            System.out.println(female);
        }
        System.out.println("//Declarative Approuch");

        List<Person> females2 = peaple.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;
        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        MALE, FEMALE
    }
}

