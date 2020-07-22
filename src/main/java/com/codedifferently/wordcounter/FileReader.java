package com.codedifferently.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) {
        readFile();

        
    }

    public static String readFile(){

        String text = "";

        try {

          File myObj = new File("/Users/es/dev/stayReadyLabs/stayready11-word-count/TheModernPrometheus.txt");
          
          Scanner scanner = new Scanner(myObj);

          while (scanner.hasNext()) {

            String data = scanner.next();
            data = data.trim().toLowerCase();
            text += data + " ";

          }

          scanner.close();
          
        } catch (FileNotFoundException e) {

          System.out.println("File not found.");
          
        }

        text = text.replaceAll("[^a-zA-Z0-9]", " "); 
        


        //System.out.println(text);
        
        return text;

    }
    
}