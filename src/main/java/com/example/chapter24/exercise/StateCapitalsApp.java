package com.example.chapter24.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitalsApp {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, Capital> stateCapitalMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader("MoreStateCapitals.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("::");
                String state = parts[0];
                Capital capital = new Capital(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                stateCapitalMap.put(state, capital);
            }
        }

        System.out.println(stateCapitalMap.size() + " STATE/CAPITAL PAIRS LOADED.");
        System.out.println("==============================");
        for (String state : stateCapitalMap.keySet()) {
            Capital capital = stateCapitalMap.get(state);
            System.out.println(state + " - " + capital.getName() + " | " + "Pop: " + capital.getPopulation() + " | Area: " + capital.getSquareMileage() + " sq mi");
        }

        System.out.println();
        System.out.print("Please enter the lower limit for capital city population: ");
        double population = Double.parseDouble(scanner.nextLine());
        System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + population + ": ");
        for (Map.Entry<String, Capital> entry : stateCapitalMap.entrySet()) {
            Capital capital = entry.getValue();
            String state = entry.getKey();
            if (capital.getPopulation() > population) {
                System.out.println(state + " - " + capital.getName() + " | " + "Pop: " + capital.getPopulation() + " | Area: " + capital.getSquareMileage() + " sq mi");
            }
        }

        System.out.println();
        System.out.println("Please enter the upper limit for capital city sq mileage:");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("LISTING CAPITALS WITH AREAS LESS THAN " + area + ": ");
        for (Map.Entry<String, Capital> entry : stateCapitalMap.entrySet()) {
            Capital capital = entry.getValue();
            String state = entry.getKey();
            if (capital.getSquareMileage() < area) {
                System.out.println(state + " - " + capital.getName() + " | " + "Pop: " + capital.getPopulation() + " | Area: " + capital.getSquareMileage() + " sq mi");
            }
        }

        scanner.close();
    }
}
