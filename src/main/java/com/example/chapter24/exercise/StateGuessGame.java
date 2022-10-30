package com.example.chapter24.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StateGuessGame {
    
    public static void main(String[] args) throws Exception {
        
        Map<String, String> stateCapitalMap = new HashMap<>();
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
			String[] stateCapitalPair = currentLine.split("::");
			stateCapitalMap.put(stateCapitalPair[0], stateCapitalPair[1]);
        }

        scanner.close();

        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("READY TO TEST YOUR KNOWLEDGE?");
        String state = getRandomState(stateCapitalMap.keySet());
        System.out.println("WHAT IS THE CAPITAL OF '" + state + "'?");
        String capitalInput = consoleScanner.nextLine();
        String capitalAnswer = stateCapitalMap.get(state);
        if (capitalInput.equalsIgnoreCase(capitalAnswer)) {
            System.out.println("NICE WORK! " + capitalInput + " IS CORRECT!");
        } else {
            System.out.println("OOPS! " + capitalInput + " IS NOT CORRECT!");
        }

        consoleScanner.close();
        
    }

    private static String getRandomState(Set<String> stateSet) {
        Random random = new Random();

        int randomNumber = random.nextInt(stateSet.size());
        Iterator<String> iterator = stateSet.iterator();
        int currentIndex = 0;
        String randomState = null;

        while (iterator.hasNext()) {
            randomState = iterator.next();

            if (currentIndex == randomNumber) {
                return randomState;
            }

            currentIndex++;
        }
        return randomState;
    }
}
