package com.blind75.dynamicprograming;

import java.util.List;

public class WordBreak_139 {
    /*
    *  Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.



        Example 1:

        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
        Example 2:

        Input: s = "applepenapple", wordDict = ["apple","pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: false

    *
    * * * */

    public static void main(String[] args) {

        String  s = "leetcode";
        List<String> wordDict = List.of("leet","code");

        System.out.println("Input 1= "+s+ " Input2= "+wordDict  +" => "+new WordBreak_139().wordBreak(s,wordDict));

        String  s1 = "applepenapple";
        List<String> wordDict1 = List.of("apple","pen");
        System.out.println("Input 1= "+s1+ " Input2= "+wordDict1  +" => "+new WordBreak_139().wordBreak(s1,wordDict1));

        String  s2 = "catsandog";
        List<String> wordDict2 = List.of("cats","dog","sand","and","cat");
        System.out.println("Input 1= "+s2+ " Input2= "+wordDict2  +" => "+new WordBreak_139().wordBreak(s2,wordDict2));


    }


    public boolean wordBreak(String inputString, List<String> wordDict) {
//        StringBuilder sb= new StringBuilder(s);
        int k=0,j=0;
        boolean status=false;
//        char[] carr=s.toCharArray();
        for (String s : wordDict) {

            if (inputString.startsWith(s)) {
                int wordLength = s.length();
                inputString = inputString.substring(wordLength, inputString.length());

                if (inputString.isEmpty()) {
                    status = true;
                }
            }
        }
        return status;
    }

}
