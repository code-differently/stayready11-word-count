package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {
    WordCounter wordCounts;
    File files;

    @Before
    public void initial() throws FileNotFoundException {
        wordCounts = new WordCounter();
        files = new File("Random.txt");
        wordCounts.counting(files);

    }

    @Test
    public void WordCountTest() {  
        Integer actual = wordCounts.wordCount("Chicago");
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
        
    }

    @Test
    public void MostFrequentTest() {  
        String actual = wordCounts.mostFrequency();
        String expected = "The most used word is: Chicago";

        Assert.assertEquals(expected, actual);
        
    }

    @Test
    public void LeastFrequentTest() {
        String actual = wordCounts.leastFrequency();
        String expected = "The least used word is: IL";

        Assert.assertEquals(expected, actual);
        
    }

    @Test
    public void UniqueWordsTest() {
        Integer actual = wordCounts.uniqueWords();
        Integer expected = 14;

        Assert.assertEquals(expected, actual);
        
    }

    @Test
    public void LongestWordTest() {
        String actual = wordCounts.longestWord();
        String expected = "The longest word is: University";

        Assert.assertEquals(expected, actual);
        
    }


}
