package com.example.chapter24.exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class StateCapitals {
    
    public static void main(String[] args) throws IOException {
        
        Map<String, String> stateCapitalMap = new TreeMap<>(StateCapitalsExtractor.extract());
        PrintWriter out = new PrintWriter(new FileWriter("StateCapitals.txt"));

        for (Map.Entry<String, String> entry : stateCapitalMap.entrySet()) {
            String state = entry.getKey();
            String capital = entry.getValue();
            out.println(state + "::" + capital);
        }

        out.flush();
        out.close();
    }
}
