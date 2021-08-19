package com.blind75.string;

public class ValidPalindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s3 = " ";
        String s4 = "aa";
        System.out.println("OUTPUT->  " + isPalindrome(s4));
        System.out.println("OUTPUT->  " + isPalindrome(s3));
        System.out.println("OUTPUT->  " + isPalindrome(s1));
        System.out.println("OUTPUT->  " + isPalindrome(s));
    }


    public static boolean isPalindrome(String s) {
        String inputString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = inputString.length() - 1;
        while (left <= right) {
            if (inputString.charAt(left) != inputString.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
