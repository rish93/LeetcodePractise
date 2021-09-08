package com.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        Arrays.stream(input).map(i -> i * i).forEach(a -> System.out.println(a));  // square the number

        System.out.println(Arrays.stream(input).filter(inp -> inp % 2 != 0).map(inp -> inp * inp).sum());  // returns the odd numbers sum.of square

    }

}
