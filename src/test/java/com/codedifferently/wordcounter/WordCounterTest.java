package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class WordCounterTest {

    String file="test.txt";
    WordCounter wordC;
    @Before
    public void setUp(){
        wordC=new WordCounter(file);

    }

    @Test
    public void constructorTest(){
        // Given
        String word="purposes";
        boolean expected=true;

        // When
        HashMap<String,Integer> wordMap=wordC.getWords();
        boolean actual=wordMap.containsKey(word);

        // Then
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void occurencesTest(){
        // Given
        String expected="this occured 3 time(s)\n"+
                        "purposes occured 2 time(s)\n"+
                        "is occured 1 time(s)\n"+
                        "a occured 2 time(s)\n"+
                        "test occured 1 time(s)\n"+
                        "file occured 2 time(s)\n"+
                        "for occured 1 time(s)\n"+
                        "testing occured 1 time(s)";

        // When
        String actual=wordC.occurences();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void uniqueOccurencesTest(){
        // Given
        String expected= "is occured 1 time(s)\n"+
            "test occured 1 time(s)\n"+
            "for occured 1 time(s)\n"+
            "testing occured 1 time(s)";

        // When
        String actual=wordC.uniqueOccurences();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void wordCountTest(){
        // Given
        Integer expected=-1;

        // When
        Integer actual=wordC.wordCountOf("Bob");

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void wordCountTest2(){
        // Given
        Integer expected=2;

        // When
        Integer actual=wordC.wordCountOf("a");

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void wordCountTest3(){
        // Given
        Integer expected=996;

        // When
        WordCounter largeText=new WordCounter("TheModernPrometheus.txt");
        Integer actual=largeText.wordCountOf("that");

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void longestWordTest(){
        // Given
        String expected="purposes";

        // When
        String actual=wordC.longestWord();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void alphabeticalTest(){
        // Given
        String expected="a occured 2 time(s)\n"+
            "file occured 2 time(s)\n"+
            "for occured 1 time(s)\n"+
            "is occured 1 time(s)\n"+
            "purposes occured 2 time(s)\n"+
            "test occured 1 time(s)\n"+
            "testing occured 1 time(s)\n"+
            "this occured 3 time(s)";

        // When
        String actual=wordC.alphabeticalOrder();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void mostLeastTest(){
        // Given
        String expected="-Most used word(s)-\n"+
            "this occured 3 time(s)\n"+
            "purposes occured 2 time(s)\n"+
            "a occured 2 time(s)\n"+
            "file occured 2 time(s)\n"+
            "-Least used word(s)-\n"+
            "is occured 1 time(s)\n"+
            "test occured 1 time(s)\n"+
            "for occured 1 time(s)\n"+
            "testing occured 1 time(s)";

        // When
        String actual=wordC.mostLeastWords();

        // Then
        Assert.assertEquals(expected,actual);
    }


}
