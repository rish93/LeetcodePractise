package com.blind75.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {


    public static void main(String[] args) {
        //    String input="dvdf"; 5+1+6  6+5+1
        String s[] = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String k = "CBB";
        //    System.out.println("OUTPUT->  "+longestUniqueSubstring(input));
        System.out.println("OUTPUT->  " + isGroupAnagram(s));
        //System.out.println("OUTPUT->  " + isAnagramOptimized(s, k));
    }
///TODO  Answer is wrong but close enough need to work to improve

    private static Map<String, Integer> isGroupAnagram(String[] s) { //List<List<String>>
        Map<String, Integer> elementMap = new HashMap<>();
        List<String> finalList = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String inp : s) {
            int count = 0;
            for (Character c : inp.toCharArray()) {
                count += c - 'a';
            }
            if (elementMap.containsValue(count)) {
                elementMap.put(inp, count);
                finalList.add(inp);
            } else {
                elementMap.put(inp, count);
                finalList = new ArrayList<>();
                finalList.add(inp);
            }
            resultList.add(finalList);
        }

        return elementMap;
    }

}
