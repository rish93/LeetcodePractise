package com.TopInterview150;

public class ValidPalindrome_125 {
/*
*  A phrase is a palindrome if, after converting all uppercase
*  letters into lowercase letters and
*  removing all non-alphanumeric characters, it reads
*  the same forward and backward. Alphanumeric characters
*  include letters and numbers.
*  Given a string s, return true if it is a palindrome,
*  or false otherwise.
*
*   Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
*
* */
    public static void main(String[] args) {
        String str= "A man, a plan, a canal: Panama";
         str= "ab_a";
//         str= "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(str));
    }

    private static boolean validPalindrome(String str){
         str=str.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]","")
                 .replaceAll(" ","");
         char[] charArray= str.toCharArray();
         for(int i=0,j=str.length()-1;i<str.length();i++,j--){
            if(charArray[i]!=charArray[j]){
                return false;
            }

        }
        return true;
    }
}
