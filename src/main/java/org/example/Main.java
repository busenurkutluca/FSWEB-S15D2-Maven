package org.example;

import org.example.entity.Task;
import org.example.entity.TaskData;
import org.example.entity.Priority;
import org.example.entity.Status;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. Görevleri oluşturma
        Task task1 = new Task("Project A", "Fix bugs", Priority.HIGH,"Ann",  Status.ASSIGNED);
        Task task2 = new Task("Project B", "Develop feature", Priority.MED,"Bob", Status.IN_PROGRESS);
        Task task3 = new Task("Project C", "Write tests", Priority.LOW,"Carol",  Status.IN_QUEUE);
        Task task4 = new Task("Project D", "Refactor code", Priority.MED,null,  Status.IN_QUEUE); // Unassigned task

        // 2. Ann, Bob ve Carol için görevleri ayırma
        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task2);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(task3);

        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(task4); // Atanmamış görev

        // 3. TaskData ile bu görevleri yükleme
        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        // 4. Tüm çalışanların görevlerini raporlama
        System.out.println("Tüm çalışanların görevleri:");
        Set<Task> allTasks = taskData.getTasks("all");
        allTasks.forEach(task -> System.out.println(task));

        // 5. Her bir çalışanın görevlerini raporlama
        System.out.println("\nAnn'in görevleri:");
        Set<Task> annTasks = taskData.getTasks("ann");
        annTasks.forEach(task -> System.out.println(task));

        System.out.println("\nBob'un görevleri:");
        Set<Task> bobTasks = taskData.getTasks("bob");
        bobTasks.forEach(task -> System.out.println(task));

        System.out.println("\nCarol'un görevleri:");
        Set<Task> carolTasks = taskData.getTasks("carol");
        carolTasks.forEach(task -> System.out.println(task));

        // 6. Atanmamış görevleri raporlama
        System.out.println("\nAtanmamış görevler:");
        Set<Task> unassigned = taskData.getTasks("unassigned");
        unassigned.forEach(task -> System.out.println(task));

        // 7. Birden fazla çalışana atanmış görevler var mı kontrol etme (getIntersect)
        System.out.println("\nBirden fazla çalışana atanmış görevler var mı?");
        Set<Task> intersectTasks = taskData.getIntersect(annsTasks, bobsTasks);
        if (intersectTasks.isEmpty()) {
            System.out.println("Birden fazla çalışana atanmış görev yok.");
        } else {
            intersectTasks.forEach(task -> System.out.println(task));
        }
    }
}