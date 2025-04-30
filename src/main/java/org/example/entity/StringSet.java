package org.example.entity;

import java.util.*;

public class StringSet {

    private static final String TEXT = "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. " +
            "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, " +
            "and in November he began working on the manuscript in earnest. To add the finishing touches he researched " +
            "natural history in connection with the animals presented in the book and then had the book examined " +
            "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations " +
            "to the original copy, on publication he was advised to find a professional illustrator so the pictures " +
            "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret " +
            "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the" +
            " children.\n" +
            "\n" +
            "Carroll began planning a print edition of the Alice story in 1863. " +
            "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice." +
            " A diary entry for 2 July says that he received a specimen page of the print edition around that date. " +
            "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations " +
            "by Carroll, dedicating it as a Christmas Gift to a Dear Child in Memory of a Summer's Day." +
            " The published version of Alice's Adventures in Wonderland is about twice the length of " +
            "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, " +
            "that did not appear in the manuscript. The only known manuscript copy of Under Ground " +
            "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

    public static Set<String> findUniqueWords() {
        // Noktalama işaretlerini temizle, ama tireyi koru
        String cleanedText = TEXT.replaceAll("[.,!?\"]", "").toLowerCase();
        // Kelimelere ayır
        String[] words = cleanedText.split("\\s+");
        // Unique kelimeleri bir TreeSet'e ekle (otomatik sıralama için)
        Set<String> uniqueWords = new TreeSet<>();
        for (String word : words) {
            // Sayıları çıkar, tireyi koru
            if (!word.matches(".*\\d+.*") && !word.isEmpty()) {
                // "macdonald's" ve benzeri kelimelerdeki kesme işaretini kaldır
                word = word.replaceAll("['’]", "");
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }
}