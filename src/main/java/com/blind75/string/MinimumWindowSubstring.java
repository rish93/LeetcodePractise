/*
package com.blind75.string;
*/


//ON HOLD


/*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
        The testcases will be generated such that the answer is unique.

        A substring is a contiguous sequence of characters within the string.

        Example 1:

        Input: s = "ADOBECODEBANC", t = "ABC"
        Output: "BANC"
        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        Example 2:

        Input: s = "a", t = "a"
        Output: "a"
        Explanation: The entire string s is the minimum window.
        Example 3:

        Input: s = "a", t = "aa"
        Output: ""
        Explanation: Both 'a's from t must be included in the window.
        Since the largest window of s only has one 'a', return empty string.*//*


import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        String input = "ADOBECODEBANC";
        String t = "ABC";
        //System.out.println("OUTPUT->  "+longestUniqueSubstring(input));
        System.out.println("OUTPUT->  " + tryMinWindow(input, t));


    }

    private static String tryMinWindow(String s, String t) {
        char[] compChar = t.toCharArray();
        char[] mainChar = s.toCharArray();
        int left = 0;
        int right = 0;
        int min = 0;
        List<Character> finalChar = new ArrayList<>();
        while (t.length() <= s.length() && right < s.length()) {
            if (t.contains("" + mainChar[right])) {
                finalChar.add(mainChar[right]);
                right++;
            }
            else   // ON HOLD TILL we


        }
        return null;
    }
}
*/
