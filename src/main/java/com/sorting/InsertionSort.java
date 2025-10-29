package com.sorting;

import java.util.Arrays;

public class InsertionSort {
    //https://youtu.be/8mJ-OhcfpYg?si=kbXIGGdkEZcHUpOS
    public static void main(String[] args) {
        int[] input = new int[]{8, 2, 4, 1, 3};
        int[] input1 = new int[]{6, 3, 1, 9, 10, 5};
        int[] arr = insertionSort(input);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(insertionSort(input1)));

        insertionSortChatGpt(input1);
    }


    /*
       TODO for every iteration iterate backwards
        to insert value to correct position until previous element is greater than current element
    * */
    private static int[] insertionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {

            int j = i;
            //int temp = -1;
            while (j != 0) {
                if (input[j] < input[j - 1]) {
                   int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
                j--;
            }

        }

        return input;

    }


    static void insertionSortChatGpt(int[] input){

            for(int i=1;i< input.length;i++){

                int j=i-1;
                int key=input[i];

                while(j>=0 && input[j]>key){

                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = key;
            }
        System.out.println("insertionSortChatGpt "+Arrays.toString(input));
    }
}
