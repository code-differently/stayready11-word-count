package com.codedifferently.wordcounter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter{

    HashMap<String,Integer> map = new HashMap<String,Integer>();

    public String readAsString(String fileName) throws Exception{
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public String outputAll(String fileName) throws Exception {
        String output = "";
        String data = readAsString(fileName).toLowerCase();
        String[] splitData = data.split("\\W+");
        for(int i = 0; i < splitData.length; i++){
            if(!map.containsKey(splitData[i])){
                map.put(splitData[i], 1);
            }
            else if(map.containsKey(splitData[i])){
                int currentVal = map.get(splitData[i]);
                map.replace(splitData[i], currentVal + 1);
            }
        }
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            output += "\nWord: " + entry.getKey() + " | Word count: " + entry.getValue();
        }
        return output;
        }

    public String outputUnique(String fileName) throws Exception{
        String output = "";
        String data = readAsString(fileName).toLowerCase();
        String[] splitData = data.split("\\W+");
        for(int i = 0; i < splitData.length; i++){
            if(!map.containsKey(splitData[i])){
                map.put(splitData[i], 1);
            }
            else if(map.containsKey(splitData[i])){
                int currentVal = map.get(splitData[i]);
                map.remove(splitData[i], currentVal);
            }
        }
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            output += "\nUnique Word: " + entry.getKey() + " | Word count: " + entry.getValue();
        }
        return output;
    }
    public String outputAlpha(String fileName) throws Exception{
        String output = "";
        String data = readAsString(fileName).toLowerCase();
        String[] splitData = data.split("\\W+");
        for(int i = 0; i < splitData.length; i++){
            if(!map.containsKey(splitData[i])){
                map.put(splitData[i], 1);
            }
            else if(map.containsKey(splitData[i])){
                int currentVal = map.get(splitData[i]);
                map.replace(splitData[i], currentVal + 1);
            }
        }
        TreeMap<String,Integer> tree = new TreeMap<String,Integer>();
        tree.putAll(map);
        for (Map.Entry<String,Integer> entry: tree.entrySet()) {
            output += "\nAlpha Word: " + entry.getKey() + " | Word count: " + entry.getValue();
        }
        return output;
    }
    public String outputMostLeast(String fileName) throws Exception{
        String output = "Most to Least: ";
        String data = readAsString(fileName).toLowerCase();
        String[] splitData = data.split("\\W+");
        for(int i = 0; i < splitData.length; i++){
            if(!map.containsKey(splitData[i])){
                map.put(splitData[i], 1);
            }
            else if(map.containsKey(splitData[i])){
                int currentVal = map.get(splitData[i]);
                map.replace(splitData[i], currentVal + 1);
            }
        }
        Object[] vals = map.values().toArray();
        int most = (int) vals[0];
        for(int i = 1; i < vals.length; i++){
            if(most < (int)vals[i]){
                most = (int)vals[i];
            }
        }
        int num = most;
        for(int i = num; i > 0; i--){
            for(Map.Entry<String,Integer> entry: map.entrySet()) {
                if(entry.getValue() == i){
                    output += "\nWord: " + entry.getKey() + " | Word count: " + entry.getValue();
                }
            }
        }
        return output;
    }
    public String outputLongestWord(String fileName) throws Exception {
        String longest = "";
        String data = readAsString(fileName).toLowerCase();
        String[] splitData = data.split("\\W+");
        int longestLength = splitData[0].length();
        for(int i = 1; i < splitData.length; i++){
            if(splitData[i].length() > longestLength){
                longestLength = splitData[i].length();
                longest = splitData[i];
            }
        }
        return longest;
    }
    public int outputWordCount(String fileName, String word) throws Exception {
        String output = "Most to Least: ";
        String data = readAsString(fileName).toLowerCase();
        String[] splitData = data.split("\\W+");
        for(int i = 0; i < splitData.length; i++){
            if(!map.containsKey(splitData[i])){
                map.put(splitData[i], 1);
            }
            else if(map.containsKey(splitData[i])){
                int currentVal = map.get(splitData[i]);
                map.replace(splitData[i], currentVal + 1);
            }
        }
        return map.get(word.toLowerCase());
    }

}

