package com.Practise;

import java.util.Arrays;

public class Mindtree {

    public static void main(String[] args) {

        int arr1[] = new int []{1,2,3,4,5};
        int arr2[] = new int []{5,6,7,8,9};


        Arrays.stream(arr1).forEach(value -> Arrays.stream(arr2).filter(value1 -> value1==value).distinct().forEach(System.out::println));

        Arrays.stream(arr1).filter(i -> Arrays.stream(arr2).anyMatch(value -> value == i ))
                .forEach(System.out::println);

    }
}
