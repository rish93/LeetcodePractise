
//Learn Maniker Algo
package com.blind75.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // babab
        System.out.println(longestPalindrome("babad"));   //bab or aba
        System.out.println(longestPalindrome("madam"));   //madam
        System.out.println(longestPalindrome("cbbd"));//bb
        System.out.println(longestPalindrome("a")); //a
        System.out.println(longestPalindrome("a")); //a
        System.out.println(longestPalindrome("ac")); //ac
    }
    public static String longestPalindrome(String s) {
        //take one character ata a time
        //reverese it everytime, and check contains exist in that string
        //take max length everytime.

        char[] charArr=s.toCharArray();
        String stringForm="";
        String palindrom="";
        Map<String,Integer> map= new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<charArr.length;i++){
            palindrom="";
            stringForm+=String.valueOf(charArr[i]);
            if(stringForm.length()!=1){
                char[]arrC=stringForm.toCharArray();
                int k=0;
                int l=arrC.length-1;
                while (k<=l){
                  char temp=  arrC[k];
                  arrC[k]=arrC[l];
                  arrC[l] =temp;
                  k++;
                  l--;
                }
                palindrom+=String.valueOf(arrC);
                max= Math.max(palindrom.length(),max);
                if(s.contains(palindrom))
                     map.put(palindrom,max);
            }
        }
        //System.out.println(map);


        return  map.entrySet().stream().max(Map.Entry.comparingByValue()).isPresent()?
                map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()
                :"";
    }

    //wrong
    public static String longestPalindromeSubstring(String s) {
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
        return "";
    }


}

