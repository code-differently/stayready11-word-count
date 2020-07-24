package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {
    WordCounter wordc;
    File file;

    @Before
    public void initialize() throws FileNotFoundException{
        wordc = new WordCounter();
        file = new File("testFile.txt");
        wordc.addToMap(file);
    }

    @Test
    public void addToMapTest(){
        
        int actual = wordc.getMap().size();
        int expected = 7;
        
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void uniqueWordCountTest(){

        int actual = wordc.uniqueWordCount();
        int expected = 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mostUsedWordTest(){
        String actual = wordc.mostUsedWord();
        String expected = "the";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leastUsedWordTest(){
        String actual = wordc.leastUsedWord();
        String expected = "hill";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestWordTest(){
        String actual = wordc.longestWord();
        String expected = "prairie";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWordCountTest(){
        int actual = wordc.getWordCount("the");
        int expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWordCountTest2(){
        int actual = wordc.getWordCount("home");
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkFileName(){
        String fileName = "testFile.txt";
        boolean actual = wordc.checkFileName(fileName);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
}