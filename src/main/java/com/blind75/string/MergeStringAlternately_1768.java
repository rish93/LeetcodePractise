package com.blind75.string;

public class MergeStringAlternately_1768 {

    /*
    * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
      Return the merged string.



        Example 1:

        Input: word1 = "abc", word2 = "pqr"
        Output: "apbqcr"
        Explanation: The merged string will be merged as so:
        word1:  a   b   c
        word2:    p   q   r
        merged: a p b q c r
        Example 2:

        Input: word1 = "ab", word2 = "pqrs"
        Output: "apbqrs"
        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
        word1:  a   b
        word2:    p   q   r   s
        merged: a p b q   r   s
        Example 3:

        Input: word1 = "abcd", word2 = "pq"
        Output: "apbqcd"
        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
        word1:  a   b   c   d
        word2:    p   q
        merged: a p b q c   d


        Constraints:

        1 <= word1.length, word2.length <= 100
        word1 and word2 consist of lowercase English letters.
    *
    *
    * */

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        //Output: "apbqcr"
        System.out.println(mergeAlternately(word1, word2));

        String s1 = "abcd", s2 = "pq";
        /*
        *
          Output: "apbqcd"
          Explanation: Notice that as word1 is longer, "cd" is appended to the end.
          word1:  a   b   c   d
          word2:    p   q
          merged: a p b q c   d
        * */
        System.out.println(mergeAlternately(s1, s2));



        String s3="cdf"; String s4 ="a";
        /**
         * o/p "cadf"
         * */
        System.out.println(mergeAlternately(s3, s4));

    }

    public static String mergeAlternately(String word1, String word2) {
            int word1Length= word1.length();
            int word2Length= word2.length();
         //   int i = 0, j=0;
            StringBuilder result= new StringBuilder();
            if(word1Length>0 && word2Length>0){
                for (int i = 0; i < word1Length || i < word2Length; ++i) {
                    if (i < word1Length) {
                        result.append(word1.charAt(i));
                    }
                    if (i < word2Length) {
                        result.append(word2.charAt(i));
                    }
                }

                /*if(word1Length>word2Length) {
                    int diffLength = word1Length - word2Length;
                    while (i < word2Length) {
                        if(word1Length<2)
                            result.append(word1.charAt(i));
                        if(word2Length<2)
                            result.append(word2.charAt(i));
                        i++;
                    }
                    result.append(result, diffLength, word1Length);
                  } else if(word2Length>word1Length){
                        int diffLength = word2Length - word1Length;
                        while (i < word1Length) {
                            if(word1Length<2)
                               result.append(word1.charAt(i));
                            if(word2Length<2)
                                result.append(word2.charAt(i));
                            i++;
                        }
                        result.append(result, diffLength, word2Length);

                } else if(word1Length == word2Length){

                    //equal string
                    while(i<word1Length){

                        result.append(word1.charAt(i));
                        result.append(word2.charAt(i));
                        i++;
                    }

                }
                */

            }
            return result.toString();
          }
    }

