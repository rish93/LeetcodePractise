/*
Learn Maniker Algo
package com.blind75.string;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // babab
        System.out.println(longestPalindrome("babad"));   //List --> compare 1st and last bacb
        System.out.println(longestPalindrome("madam"));   //list-->0 1 baa
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int k = 0;
        List<Character> finalList = new ArrayList<>();
        while (k < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {

                right += 1;
            } else {

                right += 1;
            }
            finalList.add(s.charAt(right));
            k++;
        }

    }


}
*/
