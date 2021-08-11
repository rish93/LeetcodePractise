package com.blind75.string;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        String s = "()[]{}";
        String s1 = "({[(}]}){}";
        String s2 = "({[(])}){}";
        String s4 = "([}}])";
        System.out.println("OUTPUT->  " + isValid(s4));
        System.out.println("OUTPUT->  " + isValid(s1));
        System.out.println("OUTPUT->  " + isValid(s2));
        System.out.println("OUTPUT->  " + isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0)
            return false;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if (c == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else if (c == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}



