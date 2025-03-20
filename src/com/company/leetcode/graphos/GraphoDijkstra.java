package com.company.leetcode.graphos;

import java.util.*;

public class GraphoDijkstra {
        public static Map<String, Integer> findShortestPaths(Map<String, Map<String, Integer>> graph, String start) {
        // Distances to each node
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Priority queue to process nodes
        PriorityQueue<String> queue = new PriorityQueue<>(
                (a, b) -> distances.get(a) - distances.get(b)
        );
        queue.offer(start);

        // Track visited nodes to avoid reprocessing
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // Skip if already processed
            if (visited.contains(current)) continue;
            visited.add(current);

            // Check neighbors
            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {
                String next = neighbor.getKey();
                int weight = neighbor.getValue();

                // Calculate new distance
                int newDistance = distances.get(current) + weight;

                // Update if shorter path found
                if (newDistance < distances.get(next)) {
                    distances.put(next, newDistance);
                    queue.offer(next);
                }
            }
        }

        return distances;
    }

        public static void main(String[] args) {
        // Graph setup
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", Map.of("B", 1, "C", 4));
        graph.put("B", Map.of("A", 1, "C", 2, "D", 5));
        graph.put("C", Map.of("A", 4, "B", 2, "D", 1));
        graph.put("D", Map.of("B", 5, "C", 1));

        // Find and print shortest paths
        Map<String, Integer> distances = findShortestPaths(graph, "A");
        System.out.println("Shortest distances: " + distances);
    }
    }