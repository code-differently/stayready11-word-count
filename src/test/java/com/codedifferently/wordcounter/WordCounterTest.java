package com.codedifferently.wordcounter;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {
    @Test
    public void outputTest() throws Exception {
        //Given
        String expected = "\nWord: here | Word count: 1"+
        "\nWord: no | Word count: 1"+
        "\nWord: enterprise | Word count: 1"+
        "\nWord: forebodings | Word count: 1"+
        "\nWord: commencement | Word count: 1"+
        "\nWord: disaster | Word count: 1"+
        "\nWord: yesterday | Word count: 1"+
        "\nWord: that | Word count: 1"+
        "\nWord: arrived | Word count: 1"+
        "\nWord: and | Word count: 1"+
        "\nWord: of | Word count: 1"+
        "\nWord: assure | Word count: 1"+
        "\nWord: have | Word count: 1"+
        "\nWord: has | Word count: 1"+
        "\nWord: you | Word count: 2"+
        "\nWord: hear | Word count: 1"+
        "\nWord: which | Word count: 1"+
        "\nWord: will | Word count: 1"+
        "\nWord: i | Word count: 1"+
        "\nWord: is | Word count: 1"+
        "\nWord: my | Word count: 1"+
        "\nWord: an | Word count: 1"+
        "\nWord: the | Word count: 1"+
        "\nWord: with | Word count: 1"+
        "\nWord: such | Word count: 1"+
        "\nWord: accompanied | Word count: 1"+
        "\nWord: task | Word count: 1"+
        "\nWord: regarded | Word count: 1"+
        "\nWord: rejoice | Word count: 1"+
        "\nWord: to | Word count: 2"+
        "\nWord: evil | Word count: 1"+
        "\nWord: first | Word count: 1";

        //When
        WordCounter counter = new WordCounter();
        String actual = counter.outputAll("text.txt");

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void uniqueWordsTest() throws Exception {
        //Given
        String expected = "\nUnique Word: here | Word count: 1"+
                "\nUnique Word: no | Word count: 1"+
                "\nUnique Word: enterprise | Word count: 1"+
                "\nUnique Word: forebodings | Word count: 1"+
                "\nUnique Word: commencement | Word count: 1"+
                "\nUnique Word: disaster | Word count: 1"+
                "\nUnique Word: yesterday | Word count: 1"+
                "\nUnique Word: that | Word count: 1"+
                "\nUnique Word: arrived | Word count: 1"+
                "\nUnique Word: and | Word count: 1"+
                "\nUnique Word: of | Word count: 1"+
                "\nUnique Word: assure | Word count: 1"+
                "\nUnique Word: have | Word count: 1"+
                "\nUnique Word: has | Word count: 1"+
                "\nUnique Word: hear | Word count: 1"+
                "\nUnique Word: which | Word count: 1"+
                "\nUnique Word: will | Word count: 1"+
                "\nUnique Word: i | Word count: 1"+
                "\nUnique Word: is | Word count: 1"+
                "\nUnique Word: my | Word count: 1"+
                "\nUnique Word: an | Word count: 1"+
                "\nUnique Word: the | Word count: 1"+
                "\nUnique Word: with | Word count: 1"+
                "\nUnique Word: such | Word count: 1"+
                "\nUnique Word: accompanied | Word count: 1"+
                "\nUnique Word: task | Word count: 1"+
                "\nUnique Word: regarded | Word count: 1"+
                "\nUnique Word: rejoice | Word count: 1"+
                "\nUnique Word: evil | Word count: 1"+
                "\nUnique Word: first | Word count: 1";
        //When
        WordCounter counter = new WordCounter();
        String actual = counter.outputUnique("text.txt");

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void alphaOutputTest() throws Exception{
        //Given
        String expected = "\nAlpha Word: accompanied | Word count: 1"+
                "\nAlpha Word: an | Word count: 1"+
                "\nAlpha Word: and | Word count: 1"+
                "\nAlpha Word: arrived | Word count: 1"+
                "\nAlpha Word: assure | Word count: 1"+
                "\nAlpha Word: commencement | Word count: 1"+
                "\nAlpha Word: disaster | Word count: 1"+
                "\nAlpha Word: enterprise | Word count: 1"+
                "\nAlpha Word: evil | Word count: 1"+
                "\nAlpha Word: first | Word count: 1"+
                "\nAlpha Word: forebodings | Word count: 1"+
                "\nAlpha Word: has | Word count: 1"+
                "\nAlpha Word: have | Word count: 1"+
                "\nAlpha Word: hear | Word count: 1"+
                "\nAlpha Word: here | Word count: 1"+
                "\nAlpha Word: i | Word count: 1"+
                "\nAlpha Word: is | Word count: 1"+
                "\nAlpha Word: my | Word count: 1"+
                "\nAlpha Word: no | Word count: 1"+
                "\nAlpha Word: of | Word count: 1"+
                "\nAlpha Word: regarded | Word count: 1"+
                "\nAlpha Word: rejoice | Word count: 1"+
                "\nAlpha Word: such | Word count: 1"+
                "\nAlpha Word: task | Word count: 1"+
                "\nAlpha Word: that | Word count: 1"+
                "\nAlpha Word: the | Word count: 1"+
                "\nAlpha Word: to | Word count: 2"+
                "\nAlpha Word: which | Word count: 1"+
                "\nAlpha Word: will | Word count: 1"+
                "\nAlpha Word: with | Word count: 1"+
                "\nAlpha Word: yesterday | Word count: 1"+
                "\nAlpha Word: you | Word count: 2";
        //When
        WordCounter counter = new WordCounter();
        String actual = counter.outputAlpha("text.txt");
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void leastGreatestTest() throws Exception {
        //Given
        String expected = "Most to Least: "+
                "\nWord: you | Word count: 2"+
                "\nWord: to | Word count: 2"+
                "\nWord: here | Word count: 1"+
                "\nWord: no | Word count: 1"+
                "\nWord: enterprise | Word count: 1"+
                "\nWord: forebodings | Word count: 1"+
                "\nWord: commencement | Word count: 1"+
                "\nWord: disaster | Word count: 1"+
                "\nWord: yesterday | Word count: 1"+
                "\nWord: that | Word count: 1"+
                "\nWord: arrived | Word count: 1"+
                "\nWord: and | Word count: 1"+
                "\nWord: of | Word count: 1"+
                "\nWord: assure | Word count: 1"+
                "\nWord: have | Word count: 1"+
                "\nWord: has | Word count: 1"+
                "\nWord: hear | Word count: 1"+
                "\nWord: which | Word count: 1"+
                "\nWord: will | Word count: 1"+
                "\nWord: i | Word count: 1"+
                "\nWord: is | Word count: 1"+
                "\nWord: my | Word count: 1"+
                "\nWord: an | Word count: 1"+
                "\nWord: the | Word count: 1"+
                "\nWord: with | Word count: 1"+
                "\nWord: such | Word count: 1"+
                "\nWord: accompanied | Word count: 1"+
                "\nWord: task | Word count: 1"+
                "\nWord: regarded | Word count: 1"+
                "\nWord: rejoice | Word count: 1"+
                "\nWord: evil | Word count: 1"+
                "\nWord: first | Word count: 1";

        //When
        WordCounter counter = new WordCounter();
        String actual = counter.outputMostLeast("text.txt");

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void outputLongestWordTest() throws Exception {
        //Given
        String expected = "commencement";

        //When
        WordCounter counter = new WordCounter();
        String actual = counter.outputLongestWord("text.txt");

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void outputWordCountTest() throws Exception {
        //Given
        int expected = 2;

        //When
        WordCounter counter = new WordCounter();
        int actual = counter.outputWordCount("text.txt", "You");

        //Then
        Assert.assertEquals(expected, actual);
    }

}
