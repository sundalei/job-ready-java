package com.example.chapter24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StateGuessGameWithMultiTimes {

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
        System.out.println("How many times do you want to guess?");
        int times = Integer.parseInt(consoleScanner.nextLine());

        List<String> states = getRandomState(stateCapitalMap.keySet(), times);

        int score = 0;
        for (String state : states) {
            System.out.println("WHAT IS THE CAPITAL OF '" + state + "'?");
            String capitalInput = consoleScanner.nextLine();
            String capitalAnswer = stateCapitalMap.get(state);
            if (capitalInput.equalsIgnoreCase(capitalAnswer)) {
                System.out.println("NICE WORK! " + capitalInput + " IS CORRECT!");
                score++;
            } else {
                System.out.println("OOPS! " + capitalInput + " IS NOT CORRECT!");
                score--;
            }
            System.out.println();
        }

        System.out.println("Your score is: " + score);

        consoleScanner.close();
    }

    private static List<String> getRandomState(Set<String> stateSet, int times) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>(times);
        while (set.size() < times) {
            set.add(random.nextInt(stateSet.size()));
        }

        Iterator<String> iterator;
        int currentIndex;
        String randomState;
        List<String> randomStates = new ArrayList<>();

        for (Integer randomNumber : set) {
            iterator = stateSet.iterator();
            currentIndex = 0;

            while (iterator.hasNext()) {
                randomState = iterator.next();

                if (currentIndex == randomNumber) {
                    randomStates.add(randomState);
                    break;
                }

                currentIndex++;
            }
        }

        return randomStates;
    }
}
