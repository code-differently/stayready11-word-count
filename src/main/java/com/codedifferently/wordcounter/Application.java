package com.codedifferently.wordcounter;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException{

        WordCounter wordc = new WordCounter();
        Scanner scan = new Scanner(System.in);
        File file;

        System.out.print("\n\nWhat file would you like to use? ");
        String fileName = scan.nextLine();

        if(!(wordc.checkFileName(fileName)))
            fileName += ".txt";

        file = new File(fileName);
        
        System.out.println("");
        wordc.addToMap(file);
        System.out.print("\nThe number of unique words in the file: " + wordc.uniqueWordCount());

        System.out.print("\nThe most frequently used word from the file: " + wordc.mostUsedWord());
        System.out.print("\nThe least frequently used word from the file: " + wordc.leastUsedWord());
        System.out.print("\nThe longest word from the file: " + wordc.longestWord());

        System.out.print("\n\nPick a word that you want to know the occurrences of: " );
        String word = scan.nextLine();
        scan.close();
        System.out.println("Number of occurrences of " + word + ": " + wordc.getWordCount(word));
    }
}