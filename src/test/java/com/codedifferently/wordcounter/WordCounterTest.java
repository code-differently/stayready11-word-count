package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.TreeMap;

public class WordCounterTest {
    File file;
    WordCounter wordCounter;

    @Before
    public void setUp() {
        file = new File("C:\\Kaveesha\\Github\\devCodeDifferently\\stayReadyLabs\\stayready11-word-count\\SampleText.txt");
        wordCounter = new WordCounter();
        wordCounter.readFile(file);
    }

    @Test
    public void constructorTest() {
        int expectedSizeOfMap = 0;

        WordCounter wordCounterForConstructor = new WordCounter();
        int actualSizeOfMap = wordCounterForConstructor.getTrackUniqueWords().size();

        Assert.assertEquals(expectedSizeOfMap, actualSizeOfMap);
    }

    @Test
    public void getTrackUniqueWordsTest() {
        int expectedSize = 7;

        TreeMap<String, Integer> uniqueWords = wordCounter.getTrackUniqueWords();
        int actualSize = uniqueWords.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getNumberOfUniqueWordsTest() {
        String expected = "There are 7 unique words excluding non alphabetic characters.\n";
    }

    @Test
    public void getOccurrencesOfWordsTest() {
        String expectedAnswer = "The word: \"best\" occurs 1 times.\n" +
                                "The word: \"jungle\" occurs 2 times.\n" +
                                "The word: \"side\" occurs 1 times.\n" +
                                "The word: \"the\" occurs 2 times.\n" +
                                "The word: \"to\" occurs 1 times.\n" +
                                "The word: \"welcome\" occurs 1 times.\n" +
                                "The word: \"west\" occurs 1 times.\n";

        String actualAnswer = wordCounter.getOccurrencesOfWords();

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getMostUsedWordsTest() {
        String expectedAnswer = "The word: \"jungle\" is a word that occurs the most. It occurs 2 times!\n" +
                                "The word: \"the\" is a word that occurs the most. It occurs 2 times!\n";

        String actualAnswer = wordCounter.getMostOrLeastUsedWords("most");

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getLeastUsedWordsTest() {
        String expectedAnswer = "The word: \"best\" is a word that occurs the least. It occurs 1 times!\n" +
                                "The word: \"side\" is a word that occurs the least. It occurs 1 times!\n" +
                                "The word: \"to\" is a word that occurs the least. It occurs 1 times!\n" +
                                "The word: \"welcome\" is a word that occurs the least. It occurs 1 times!\n" +
                                "The word: \"west\" is a word that occurs the least. It occurs 1 times!\n";

        String actualAnswer = wordCounter.getMostOrLeastUsedWords("least");

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getLongestWordsTest() {
        String expectedAnswer = "The word: \"welcome\" is one of the words with the longest length of 7.\n";

        String actualAnswer = wordCounter.getLongestWords();

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void numberOfWordsInStringTest() {
        String expected = "The number of unique words in the string is: 3.\n";

        String phrase = "I have 3 dogs dogs[].";
        String actual = wordCounter.numberOfWordsInString(phrase);

        Assert.assertEquals(expected, actual);
    }

}
