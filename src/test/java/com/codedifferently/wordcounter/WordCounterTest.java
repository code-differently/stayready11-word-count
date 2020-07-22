package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class WordCounterTest {

    WordCounter wc;
    @Before
    public void initialize(){
         wc = new WordCounter();
    }
    @Test
    public void createMapTest(){

        File file = new File("Test.txt");
        wc.createMap(file);

        Assert.assertEquals("[echo (Seen 3), echolocation (Seen 3), find (Seen 2), i (Seen 2), jumpstart (Seen 1), my (Seen 2), pray (Seen 1), song (Seen 1), way (Seen 1)]",wc.getMap());
    }

    @Test
    public void getMostUsedWordTest(){
        File file = new File("Test.txt");
        wc.createMap(file);
        Assert.assertEquals("echolocation", wc.getMostUsedWord());
    }

    @Test
    public void getLeastUsedWordTest(){
        File file = new File("Test.txt");
        wc.createMap(file);
        Assert.assertEquals("song", wc.getLeastUsedWord());
    }

    @Test
    public void getLongestWordTest(){
        File file = new File("Test.txt");
        wc.createMap(file);

        Assert.assertEquals("echolocation",wc.getLongestWord());
    }

    @Test
    public void getWordCountTest(){
        File file = new File("Test.txt");
        wc.createMap(file);

        Assert.assertEquals(3,wc.getWordCount("echo"));
    }

    @Test
    public void getUniqueWordsTest(){
        File file = new File("Test.txt");
        wc.createMap(file);

        Assert.assertEquals(10,wc.getUniqueWords());
    }

    @Test
    public void getMapTest(){
        File file = new File("Test.txt");
        wc.createMap(file);

        Assert.assertEquals("[echo (Seen 3), echolocation (Seen 3), find (Seen 2), i (Seen 2), jumpstart (Seen 1), my (Seen 2), pray (Seen 1), song (Seen 1), way (Seen 1)]",wc.getMap());

    }
}
