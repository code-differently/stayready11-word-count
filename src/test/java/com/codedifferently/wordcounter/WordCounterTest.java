package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class WordCounterTest {


    @Test
    public void wordCountTest() throws FileNotFoundException {
        // Given
        WordCounter wc = new WordCounter();
        // When
        String expected = "(Seen Naruto 2\n HXH 2\n YuYuHakusho 1 \n Dragonball 2 \n MHA 2";
        // Then
        String actual = wc.wordCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordTest() throws FileNotFoundException {
        // Given
        WordCounter wc = new WordCounter();
        String search = "Kenichi: The Mightiest Disciple";
        // When
        boolean actual = wc.findWord(search);
        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void findWordTest2() throws FileNotFoundException{
        // Given
        WordCounter wc = new WordCounter();
        String search = "Naruto";
        // When
        boolean actual = wc.findWord(search);
        // Then
        Assert.assertTrue(actual);
    }

}
