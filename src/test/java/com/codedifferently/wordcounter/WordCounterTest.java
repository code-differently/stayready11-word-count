package com.codedifferently.wordcounter;

import java.io.FileNotFoundException;

import org.junit.Test;

public class WordCounterTest 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        WordCounter counter = new WordCounter();

        counter.count("TheModernPrometheus.txt");
        System.out.println("");
        counter.getWord("accepted");
    }

    @Test
    public void getWordTest()
    {
        WordCounter counter = new WordCounter();

        String expected = "is Appears 2";
       String actual =  counter.getWord("is");
    }
}
