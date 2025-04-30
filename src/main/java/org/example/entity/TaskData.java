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
                return bobsTasks;
            case "carol":
                return carolsTasks;
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

    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}
