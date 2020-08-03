package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.*;

public class WordCounterTest {
  WordCounter wc = new WordCounter(); 

  String s1 = "_To Mrs. Saville, England._"; 
  String s2 = "August 5th, 17—.";
  String s3 = "Hi? I want to .fn meet!";

  File file = new File("test.txt");

  @Test
  public void processWordsTest(){
    String[] expected = {"to","mrs", "saville", "england"}; 

    String[] actual = wc.processWords(s1);

    Assert.assertArrayEquals(expected, actual);
  }

  @Test
  public void processWordsTest2(){
    String[] expected = {"august", "5th", "17"}; 

    String[] actual = wc.processWords(s2);

    Assert.assertArrayEquals(expected, actual);
  }
  
  //I am not sure how to test this:
  @Test
  public void addFileToMapTest() throws FileNotFoundException {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    map.put("to", 3); 
    map.put("meet", 1);
    map.put("hi", 1);
    map.put("i", 1); 
    map.put("want", 1);
    
    Map<String, Integer> testMap = wc.addFileToMapTester(file);

    Assert.assertEquals(map, testMap); 
  }

  @Test
  public void displayAlphabeticalTest() throws FileNotFoundException {
    Map<String, Integer> map = new TreeMap<String, Integer>();
  
    String expected = " hi i meet to want";

    map = wc.addFileToMapTester(file);
    String actual = wc.displayAlphabetical();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void displayCountOfUniqueTest() throws FileNotFoundException {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    int expected = 4;
    
    map = wc.addFileToMapTester(file);

    int actual = wc.displayCountOfUnique(); 

    Assert.assertEquals(expected, actual);
  }

  @Test 
  public void displayMostUsedWordTest() throws FileNotFoundException {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    String expected = "to";
    
    map = wc.addFileToMapTester(file);

    String actual = wc.displayMostUsedWord(); 

    Assert.assertEquals(expected, actual);
  }

  @Test 
  public void displayLeastUsedWordTest() throws FileNotFoundException {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    String expected = "hi, i, meet, want";
    
    map = wc.addFileToMapTester(file);

    String actual = wc.displayLeastUsedWord(); 

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void displayLongestWordTest() throws FileNotFoundException{
    Map<String, Integer> map = wc.addFileToMapTester(file);
    String expected = "meet, want";
    
    String actual = wc.displayLongestWord(); 
    
    Assert.assertEquals(expected, actual);

  }

  @Test 
  public void displayWordCountTest() throws FileNotFoundException {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    String str = "meet";
    int expected = 1 ;
    
    map = wc.addFileToMapTester(file);

    int actual = wc.displayWordCount(str); 

    Assert.assertEquals(expected, actual);
  }








}
