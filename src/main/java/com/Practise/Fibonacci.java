package com.Practise;

public class Fibonacci {

    public static void main(String[] args) {
        fibonacci(10);
    }

    private static void fibonacci(int n) {
        int a = 0;
        int b = 1;
        int temp;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i < n; i++) {
            System.out.println(a+b);
            temp= b;
            b=a+b;
            a=temp;

        }
    }
}
