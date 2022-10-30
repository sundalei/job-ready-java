package com.example.chapter24.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitalsReader {
	
	public static void main(String[] args) throws Exception {
		
		Map<String, String> stateCapitalMap = new HashMap<>();
		Scanner scanner = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
		
		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			String[] stateCapitalPair = currentLine.split("::");
			stateCapitalMap.put(stateCapitalPair[0], stateCapitalPair[1]);
		}
		
		System.out.println("There are " + stateCapitalMap.size() + " state/capital pairs.");
		System.out.println("STATES");
		for (String state : stateCapitalMap.keySet()) {
			System.out.println(state);
		}
	}
}
