package com.example.chapter24.exercise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StateCapitalsExtractor {
    
    public static final String URL = "https://www.britannica.com/topic/list-of-state-capitals-in-the-United-States-2119210";

    public static Map<String, String> extract() {
        Map<String, String> stateCapitalMap = new HashMap<>();

        try {
            Document doc = Jsoup.connect(URL).get();

            Elements trElements = doc.select("tbody tr");
            for (Element trElement : trElements) {
                String state = trElement.select("td").first().selectFirst("a").text();
                String capital = trElement.select("td").get(1).selectFirst("a").text();
                stateCapitalMap.put(state, capital);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return stateCapitalMap;
    }
}
