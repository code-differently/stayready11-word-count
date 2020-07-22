package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WordCounterTest {
    WordCounter obj;

    @Test
    public void getFilePathTest() {
        obj = new WordCounter();

        String expected = "TheModernPrometheus.txt";
        obj.setFilePath(expected);

        Assert.assertEquals(expected, obj.getFilePath());
    }

    @Test
    public void createFileTest() {
        obj = new WordCounter();

        String filePath = "TheModernPrometheus.txt";
        obj.setFilePath(filePath);

        Assert.assertTrue(obj.createFile() != null);
    }

    @Test
    public void storeWordsTest() throws FileNotFoundException {
        obj = new WordCounter();

        String filePath = "test.txt";
        obj.setFilePath(filePath);
        obj.createFile();
        obj.storeWords();
        int expectedSize = 7;

        Assert.assertEquals(expectedSize, obj.uniqueWordCount());
    }

    // testing to make sure it finds no file
    @Test
    public void mostUsedWordTest() throws FileNotFoundException {
        obj = new WordCounter();

        String filePath = "test.txt";
        obj.setFilePath(filePath);
        obj.createFile();
        obj.storeWords();
        String expected = "lakers";

        Assert.assertEquals(expected, obj.mostUsedWord());
    }

    @Test
    public void leastUsedWordTest() throws FileNotFoundException {
        obj = new WordCounter();

        String filePath = "test.txt";
        obj.setFilePath(filePath);
        obj.createFile();
        obj.storeWords();
        String expected = "raptors";

        Assert.assertEquals(expected, obj.leastUsedWord());
    }

    @Test
    public void longestUsedWordTest() throws FileNotFoundException {
        obj = new WordCounter();

        String filePath = "test.txt";
        obj.setFilePath(filePath);
        obj.createFile();
        obj.storeWords();
        String expected = "trailblazers";

        Assert.assertEquals(expected, obj.longestWord());
    }


}
