package com.Practise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortWordsBasedOnOccurance {

    public static void main(String[] args) {
        String sentence = "I love my country India";

        StringBuilder sb = new StringBuilder();

        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();

        for(String word : sentence.split(" ")){

            hm.put(word, word.length());

        }

     System.out.println(hm.entrySet().stream().sorted((o1, o2) -> o1.getValue()>o2.getValue()?-1:1).collect(Collectors.toList()));

//        hm.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
//                .forEach(e->{
//                    sb.append(e.getKey() + " ");
//                });
//
//
//        String result = sb.substring(0).trim();
//
//        System.out.print(result);
    }
}
