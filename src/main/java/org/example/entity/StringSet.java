package org.example.entity;

import java.util.*;

public class StringSet {

    public static List<String> findUniqueWords(String text) {

        text = text.replaceAll("[.,!?\"']", "").toLowerCase();


        String[] words = text.split("\\s+");


        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        List<String> sortedUniqueWords = new ArrayList<>(uniqueWords);
        Collections.sort(sortedUniqueWords);


        return sortedUniqueWords;
    }

}
