package com.codedifferently.wordcounter;

import java.io.FileNotFoundException;

public class WordCounterTest 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        WordCounter counter = new WordCounter();

        counter.count("TheModernPrometheus.txt");
        System.out.println("");
        counter.getWord("accepted");
    }
}
