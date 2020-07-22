package com.codedifferently.wordcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordCounterTest {
    //@Before
    WordCounter wc = new WordCounter();
    @Test
    public void testAdd() {
        String[] Sentence = { "hello","how", "are", "you", "hello" };
        for (String word : Sentence) {
            wc.addWord(word);
        }
        assertEquals(4, wc.numWords());
        assertEquals(3, wc.wordsWithOccurrences(1).size());
    }
    @Test public void testFileRead() {
        wc.readWords(Arrays.asList("Avengers", "Endgame", "Infinity War"));
        assertEquals(26, wc.numWords());
        assertEquals(9,wc.longestWord().length());
    }
    @Test public void testData() {
        wc.readWords(Arrays.asList("TheModernPrometheus.txt"));
        assertEquals(6455, wc.numWords());
        assertEquals("the",wc.mostUsed());

    }

}
