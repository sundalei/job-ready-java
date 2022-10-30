package com.example.chapter24;

import java.io.FileWriter;
import java.io.PrintWriter;

public class SimpleFileIO {
    
    public static void main(String[] args) throws Exception {
        try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"))) {
            out.println("this is a line in my file...");
            out.println("a second line in my file...");
            out.println("a third line in my file...");
            out.flush();
            out.close();
        }
    }
}
