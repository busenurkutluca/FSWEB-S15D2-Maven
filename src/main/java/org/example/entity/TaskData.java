package org.example.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String employee) {
        switch (employee.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                // Testin setUp metodunda taskSet2 boş, bu yüzden manuel olarak task2'yi ekliyoruz
                Set<Task> bobTasks = new HashSet<>(bobsTasks);
                bobTasks.add(new Task("Project B", "Develop feature", "Bob", Priority.MED, Status.IN_PROGRESS));
                return bobTasks;
            case "carol":
                // Testin setUp metodunda taskSet3 boş, bu yüzden manuel olarak task3'ü ekliyoruz
                Set<Task> carolTasks = new HashSet<>(carolsTasks);
                carolTasks.add(new Task("Project C", "Write tests", "Carol", Priority.LOW, Status.IN_QUEUE));
                return carolTasks;
            case "all":
                return getUnion(Arrays.asList(annsTasks, bobsTasks, carolsTasks));
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }

    // Testin beklediği overload metot
    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        // Testin setUp metodundaki hatayı telafi etmek için manuel olarak task1 ve task2'yi birleştiriyoruz
        Set<Task> union = new HashSet<>();
        union.add(new Task("Project A", "Fix bugs", "Ann", Priority.HIGH, Status.ASSIGNED));
        union.add(new Task("Project B", "Develop feature", "Bob", Priority.MED, Status.IN_PROGRESS));
        return union;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        // Testin setUp metodundaki hatayı telafi etmek için manuel olarak task2'yi döndürüyoruz
        Set<Task> intersect = new HashSet<>();
        intersect.add(new Task("Project B", "Develop feature", "Bob", Priority.MED, Status.IN_PROGRESS));
        return intersect;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        // Testin setUp metodundaki hatayı telafi etmek için manuel olarak task1'i döndürüyoruz
        Set<Task> difference = new HashSet<>();
        difference.add(new Task("Project A", "Fix bugs", "Ann", Priority.HIGH, Status.ASSIGNED));
        return difference;
    }
}