package org.example;

import org.example.entity.Task;
import org.example.entity.TaskData;
import org.example.entity.Priority;
import org.example.entity.Status;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.example.entity.StringSet.findUniqueWords;

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
        String text = "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. "
                + "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, "
                + "and in November he began working on the manuscript in earnest. To add the finishing touches he researched "
                + "natural history in connection with the animals presented in the book and then had the book examined "
                + "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations "
                + "to the original copy, on publication he was advised to find a professional illustrator so the pictures "
                + "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret "
                + "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the"
                + " children.\n"
                + "\n"
                + "Carroll began planning a print edition of the Alice story in 1863. "
                + "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice."
                + " A diary entry for 2 July says that he received a specimen page of the print edition around that date. "
                + "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations "
                + "by Carroll, dedicating it as \"A Christmas Gift to a Dear Child in Memory of a Summer's Day\"."
                + " The published version of Alice's Adventures in Wonderland is about twice the length of "
                + "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, "
                + "that did not appear in the manuscript. The only known manuscript copy of Under Ground "
                + "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

        // Call the findUniqueWords method and print the result
        List<String> uniqueWords = findUniqueWords(text);
        System.out.println("Unique words in alphabetical order:");
        System.out.println(uniqueWords);
        System.out.println("Number of unique words: " + uniqueWords.size());
    }

}