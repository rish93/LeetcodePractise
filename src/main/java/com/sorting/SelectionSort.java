package com.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = new int[]{6,3,1,9,10,5};
        int[] arr =  selectionWorstCaseSort(input);
        System.out.println(Arrays.toString(arr));
        selectionBestCaseSort(arr);
    }


    /**
     * Selection
    TODO select min from rest of the array(except i)
     swap it with ith position
     */
    private static int[] selectionWorstCaseSort(int []input){ //On^2
        System.out.println(" unsorted array");
        Long start =System.currentTimeMillis();
        for(int i=0;i<input.length-1;i++){ //length-1 coz last elememnt is considered  sorted
            int min = i;
            int temp;
            for(int j=i+1;j<input.length;j++){
                if(input[j]<input[min])
                    min = j;
            }
            if(i!=min) {
                temp = input[i];
                input[i] = input[min];
                input[min] = temp;
            }
        }
        Long end =System.currentTimeMillis();
        System.out.println(end-start);

        return input;
    }


    private static int[] selectionBestCaseSort(int []input){ //On^2
        System.out.println("Already sorted array");
        Long start =System.currentTimeMillis();
        for(int i=0;i<input.length-1;i++){ //length-1 coz last elememnt is considered  sorted
            int min = i;
            int temp;
            for(int j=i+1;j<input.length;j++){
                if(input[j]<input[min])
                    min = j;
            }
            if(i!=min) {
                temp = input[i];
                input[i] = input[min];
                input[min] = temp;
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        return input;
    }

}
