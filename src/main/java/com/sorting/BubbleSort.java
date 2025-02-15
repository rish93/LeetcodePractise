package com.sorting;

import java.util.Arrays;

public class      BubbleSort {
    public static void main(String[] args) {

            //compare adjacent elemnt and shift large to last
            //bubble of sorted part will eventually increase and unsorted will decrease
/*time cmplexity*/
        //worst case O(n2)
        //average case case O(n2)
        //best case O(n)
/*space complexity*/
        //O(1) //not using extra space

        int [] arr = {3,1,6,4,8,2};

        for(int i=0; i< arr.length-1; i++){
            for(int j=0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.print(Arrays.toString(arr));

    }
}
