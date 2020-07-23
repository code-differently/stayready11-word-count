package com.codedifferently.wordcounter;

import java.util.Scanner;

public class WordCounterDemo {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter filepath (add another backslash for backslahes): ");
        WordCounter wc =new WordCounter(scan.nextLine());
        System.out.println("The longest word is : "+wc.longestWord()+"\n");
        System.out.println("-The words in alphabetical order-\n"+wc.alphabeticalOrder()+"\n");
        System.out.println("-Word occurences-\n"+wc.occurences()+"\n");
        System.out.println("-Unique Word occurences-\n"+wc.uniqueOccurences()+"\n");
        System.out.println(wc.mostLeastWords()+"\n");
        System.out.println("Enter word to get occurences: ");
        String word=scan.nextLine();
        System.out.println(word+" occured "+wc.wordCountOf(word)+" time(s)");




    }
}
