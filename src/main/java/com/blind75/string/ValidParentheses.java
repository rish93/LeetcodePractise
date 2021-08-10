package com.blind75.string;

public class ValidParentheses {
    public static void main(String[] args) {

        String s = "()[]{}";
        System.out.println("OUTPUT->  " + isValid(s));
    }


    public static boolean isValid(String s) {
        int pointer_a = 0;
        int freq = 0;
        for (Character c : s.toCharArray()) {
            freq = c ;
            System.out.println(freq);
        }


        return false;
    }
}



