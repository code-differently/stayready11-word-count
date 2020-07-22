package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {
    WordCounter wc;
    File file;

    @Before
    public void initialize() throws FileNotFoundException{
        wc = new WordCounter();
        file = new File("testFile.txt");
        wc.addToMap(file);
    }

    @Test
    public void addToMapTest(){
        
        int actual = wc.getMap().size();
        int expected = 7;
        
        Assert.assertEquals(expected, actual);
    }

    /*@Test(expected = FileNotFoundException.class)
    public void addToMapTest2()throws FileNotFoundException{
        File file2 = new File("Test.txt");
        wc.addToMap(file2);
    }*/

    @Test
    public void uniqueWordCountTest(){

        int actual = wc.uniqueWordCount();
        int expected = 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mostUsedWordTest(){
        String actual = wc.mostUsedWord();
        String expected = "the";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leastUsedWordTest(){
        String actual = wc.leastUsedWord();
        String expected = "hill";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestWordTest(){
        String actual = wc.longestWord();
        String expected = "prairie";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWordCountTest(){
        int actual = wc.getWordCount("the");
        int expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWordCountTest2(){
        int actual = wc.getWordCount("home");
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkFileName(){
        String fileName = "testFile.txt";
        boolean actual = wc.checkFileName(fileName);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
}
