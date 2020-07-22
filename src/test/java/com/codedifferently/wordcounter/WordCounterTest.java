package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.TreeMap;

public class WordCounterTest {

    @Test
    public void constructorTest() throws FileNotFoundException {
        // Given
        File expected = new File("TheModernPrometheus.txt");

        // When
        WordCounter wc = new WordCounter(expected);
        File actual = wc.getFile();

        // Then
        Assert.assertEquals(expected, actual);
    }

    WordCounter wc;
    @Before
    public void initialize() throws FileNotFoundException {
        File f = new File("TestFile.txt");
        wc = new WordCounter(f);
    }

    @Test
    public void getFileTest() {
        // Given
        String expected = "TestFile.txt";

        // When
        String actual = wc.getFile().toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWordsOccursTest() throws FileNotFoundException {
        // Given
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("StayReady", 1);
        hm.put("GetReady", 1);
        hm.put("#CodeDifferently", 1);

        // When
        wc.setFile(new File("TestFile2.txt"));
        wc.readFileWords();
        HashMap<String, Integer> actual = wc.getWordOccurs();

        // Then
        Assert.assertEquals(hm.size(), actual.size());
    }

    @Test
    public void getUniqueWordsTest() {
        // Given
        int expected = 12;

        // When
        wc.readFileWords();
        int actual = wc.getUniqueWords();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFileTest() throws FileNotFoundException {
        // Given
        String expected = "TheModernPrometheus.txt";
        File newF = new File(expected);

        // When
        wc.setFile(newF);
        String actual = wc.getFile().toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readFileWordsTest() throws FileNotFoundException {
        // Given
        String expected = "{#CODEDIFFERENTLY=1, GETREADY=1, STAYREADY=1}";

        // When
        wc.setFile(new File("TestFile2.txt"));
        wc.readFileWords();
        TreeMap<String, Integer> actual = new TreeMap<>(wc.getWordOccurs());

        // Then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void wordsAndOccurrencesTest() {
        // Given
        String expected = "A - 1\n" +
                "BRENT - 2\n" +
                "FILE - 2\n" +
                "HAS - 1\n" +
                "IN - 1\n" +
                "IS - 2\n" +
                "IT - 1\n" +
                "MY - 1\n" +
                "NAME - 1\n" +
                "TEXT - 1\n" +
                "THIS - 2\n" +
                "TWICE - 1";

        // When
        wc.readFileWords();
        String actual = wc.wordsAndOccurrences();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getOccurrencesTest() {
        // Given
        int expected = 2;

        // When
        wc.readFileWords();
        int actual = wc.getOccurrences("Brent");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mostUsedTest() {
        // Given
        String expected = "BRENT, THIS, IS, FILE (2)";

        // When
        wc.readFileWords();
        String actual = wc.mostUsed();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leastUsedTest() {
        // Given
        String expected = "TWICE, A, IN, TEXT, HAS, IT, MY, NAME (1)";

        // When
        wc.readFileWords();
        String actual = wc.leastUsed();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestWordTest() {
        // Given
        String expected = "TWICE, BRENT (5 characters)";

        // When
        wc.readFileWords();
        String actual = wc.longestWord();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
