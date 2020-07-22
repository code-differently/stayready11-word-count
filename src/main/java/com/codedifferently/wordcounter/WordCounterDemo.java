package com.codedifferently.wordcounter;

import java.io.File;
import java.util.Scanner;

public class WordCounterDemo {

    public static void main(String... args) {
        Scanner keyboard = new Scanner(System.in);
        WordCounter wc = new WordCounter();

        System.out.println("Word Counter");

        String again;
        do {
            System.out.print("Please enter a file to read: ");
            File file = new File(keyboard.nextLine());
            wc.setFile(file);
            wc.readFileWords();
            System.out.println("\nWord - Occurrences\n------------------\n" + wc.wordsAndOccurrences() + "\n-------------------\n" +
                    wc.getUniqueWords() + " unique words\n" +
                    "Most used word(s): " + wc.mostUsed() + "\n" +
                    "Least used word(s): " + wc.leastUsed() + "\n" +
                    "Longest word(s): " + wc.longestWord());

            String search;
            do {
                System.out.print("\nWord to search for: ");
                String searchWord = keyboard.nextLine();
                wc.getOccurrences(searchWord);
                System.out.println(searchWord + " occurs " + wc.getOccurrences(searchWord) + " times.");
                System.out.print("Search again? ");
                search = keyboard.nextLine();
            } while (search.equalsIgnoreCase("YES"));

            System.out.print("\nDo you want to use Word Counter again? ");
            again = keyboard.nextLine();

        } while(again.equalsIgnoreCase("YES"));

    }
}
