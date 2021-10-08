package com.Practise;

public class Factorial {
    public static void main(String[] args) {
        factorial(5);
    }

    private static void factorial(int n) {
        int factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial=factorial*i;

        }
        System.out.println(factorial);
    }
}
