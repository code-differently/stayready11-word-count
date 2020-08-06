package com.codedifferently.wordcounter;

import java.util.Scanner;
//import java.io.File;
import java.io.FileNotFoundException;

public class Filer
{
    public Filer(String string) {
    }

    public static String reader() throws FileNotFoundException {
        String text = "";
        Filer ob = new Filer(" /Users/taiawilliams/dev/stayReadyLabs/stayready11-word-count/TheModernPrometheus.txt");

        Scanner scan = new Scanner((Readable) ob);

        while (scan.hasNext()) {
            String data = scan.next();
            data = data.trim().toLowerCase();
            text += data + " ";

        }

        scan.close();

        text = text.replaceAll("[^a-zA-Z0-9]", " ");

        return text;
    }
}