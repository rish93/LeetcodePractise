package com.blind75.string;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {

        //    String input="dvdf";
        String s = "ABC";
        String k = "CBB";
        //    System.out.println("OUTPUT->  "+longestUniqueSubstring(input));
        System.out.println("OUTPUT->  " + isAnagram(s, k));
        System.out.println("OUTPUT->  " + isAnagramOptimized(s, k));
    }


    public static boolean isAnagram(String s, String t) {

        if (t.length() == s.length()) {
            boolean b = true;
            Map<Character, Integer> sFrequency = new HashMap<>();
            Map<Character, Integer> tFrequency = new HashMap<>();
            int frequency = 0;
            for (int i = 0; i < s.length(); i++) {
                frequency = sFrequency.getOrDefault(s.charAt(i), 0);
                sFrequency.put(s.charAt(i), frequency + 1);

                frequency = tFrequency.getOrDefault(t.charAt(i), 0);
                tFrequency.put(t.charAt(i), frequency + 1);

            }
            for (Character character : sFrequency.keySet()) {
                if (!sFrequency.get(character).equals(tFrequency.get(character)))
                    b = false;
            }
            return b;
        }
        return false;
    }//18 ms


    public static boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            count[t.charAt(i) - 'A']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }   //3 ms
}
