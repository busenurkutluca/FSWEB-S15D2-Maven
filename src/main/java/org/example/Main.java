package org.example;

import org.example.entity.*;

import java.util.*;

import static org.example.entity.StringSet.findUniqueWords;

public class Main {
    public static void main(String[] args) {
        // Set Challenge Test
        System.out.println("=== Set Challenge Test ===");

        // Task'lar oluştur
        Task task1 = new Task("ProjectA", "Design UI", "Ann", Priority.HIGH, Status.IN_PROGRESS);
        Task task2 = new Task("ProjectA", "Write API", "Ann", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("ProjectB", "Test Module", "Bob", Priority.LOW, Status.IN_QUEUE);
        Task task4 = new Task("ProjectB", "Fix Bugs", "Bob", Priority.HIGH, Status.IN_PROGRESS);
        Task task5 = new Task("ProjectC", "Database Setup", "Carol", Priority.MED, Status.ASSIGNED);
        Task task6 = new Task("ProjectC", "Optimize Queries", "Carol", Priority.LOW, Status.IN_QUEUE);
        Task task7 = new Task("ProjectA", "Design UI", "Bob", Priority.HIGH, Status.IN_PROGRESS); // Çakışan task
        Task task8 = new Task("ProjectD", "Documentation", null, Priority.LOW, Status.IN_QUEUE); // Atanmamış task

        // Set'ler oluştur
        Set<Task> annsTasks = new HashSet<>(Arrays.asList(task1, task2));
        Set<Task> bobsTasks = new HashSet<>(Arrays.asList(task3, task4, task7));
        Set<Task> carolsTasks = new HashSet<>(Arrays.asList(task5, task6));
        Set<Task> unassignedTasks = new HashSet<>(Collections.singletonList(task8));

        // TaskData oluştur
        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        // Tüm çalışanların task'ları
        System.out.println("Tüm çalışanların task'ları:");
        System.out.println(taskData.getTasks("all"));

        // Her bir çalışanın task'ları
        System.out.println("\nAnn'in task'ları:");
        System.out.println(taskData.getTasks("ann"));
        System.out.println("Bob'un task'ları:");
        System.out.println(taskData.getTasks("bob"));
        System.out.println("Carol'un task'ları:");
        System.out.println(taskData.getTasks("carol"));

        // Atanmamış task'lar
        System.out.println("\nAtanmamış task'lar:");
        System.out.println(unassignedTasks);

        // Birden fazla çalışana atanmış task'lar (kesişim)
        System.out.println("\nBirden fazla çalışana atanmış task'lar:");
        Set<Task> annBobIntersect = taskData.getIntersection(annsTasks, bobsTasks);
        Set<Task> annCarolIntersect = taskData.getIntersection(annsTasks, carolsTasks);
        Set<Task> bobCarolIntersect = taskData.getIntersection(bobsTasks, carolsTasks);
        Set<Task> duplicates = taskData.getUnion(Arrays.asList(annBobIntersect, annCarolIntersect, bobCarolIntersect));
        System.out.println(duplicates);

        System.out.println();

        // Challenge Test
        System.out.println("=== Challenge Test ===");
        Set<String> uniqueWords = StringSet.findUniqueWords();
        System.out.println("Unique kelime sayısı: " + uniqueWords.size());
        System.out.println("Unique kelimeler (alfabetik sırayla):");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}