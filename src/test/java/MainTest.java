package org.example;

import org.example.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private TaskData taskData;
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    @BeforeEach
    void setUp() {
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
        annsTasks = new HashSet<>(Arrays.asList(task1, task2));
        bobsTasks = new HashSet<>(Arrays.asList(task3, task4, task7));
        carolsTasks = new HashSet<>(Arrays.asList(task5, task6));
        unassignedTasks = new HashSet<>(Collections.singletonList(task8));

        // TaskData oluştur
        taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
    }

    @DisplayName("getTasks all metodu doğru çalışıyor mu?")
    @Test
    public void testGetTasksAll() {
        Set<Task> allTasks = taskData.getTasks("all");
        assertEquals(6, allTasks.size()); // Çakışan task bir kez sayılır
    }

    @DisplayName("getTasks ann metodu doğru çalışıyor mu?")
    @Test
    public void testGetTasksAnn() {
        Set<Task> annTasks = taskData.getTasks("ann");
        assertEquals(2, annTasks.size());
    }

    @DisplayName("getTasks bob metodu doğru çalışıyor mu?")
    @Test
    public void testGetTasksBob() {
        Set<Task> bobTasks = taskData.getTasks("bob");
        assertEquals(3, bobTasks.size());
    }

    @DisplayName("getTasks carol metodu doğru çalışıyor mu?")
    @Test
    public void testGetTasksCarol() {
        Set<Task> carolTasks = taskData.getTasks("carol");
        assertEquals(2, carolTasks.size());
    }

    @DisplayName("getUnion metodu doğru çalışıyor mu?")
    @Test
    public void testGetUnion() {
        Set<Task> union = taskData.getUnion(Arrays.asList(annsTasks, bobsTasks, carolsTasks));
        assertEquals(6, union.size());
    }

    @DisplayName("getIntersect metodu doğru çalışıyor mu?")
    @Test
    public void testGetIntersect() {
        Set<Task> intersect = taskData.getIntersect(annsTasks, bobsTasks);
        assertEquals(1, intersect.size()); // "Design UI" task'ı çakışıyor
    }

    @DisplayName("getDifference metodu doğru çalışıyor mu?")
    @Test
    public void testGetDifference() {
        Set<Task> difference = taskData.getDifference(annsTasks, bobsTasks);
        assertEquals(1, difference.size()); // Sadece "Write API" kalır
    }

    @DisplayName("findUniqueWords metodu doğru çalışıyor mu?")
    @Test
    public void testFindUniqueWords() {
        Set<String> uniqueWords = StringSet.findUniqueWords();
        assertEquals(149, uniqueWords.size()); // Tireler temizlendikten sonra 157 kelime
        assertTrue(uniqueWords.contains("alice"));
        assertTrue(uniqueWords.contains("carroll"));
    }
}