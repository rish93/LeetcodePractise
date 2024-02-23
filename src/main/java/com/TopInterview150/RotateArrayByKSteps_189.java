package com.TopInterview150;

import java.util.Arrays;

public class RotateArrayByKSteps_189 {

    public static void main(String[] args) {

        int []arr= {1,2,3,4,5,6,7};
        int k=3;
       System.out.println(Arrays.toString(rotateByKSteps(arr, k)));
    }

    static int[] rotateByKSteps(int []nums, int k){
        //rotate complete array, the from 0 to k-1 and then from k to arr.length
        rotateArr(nums, 0, nums.length-1);
        rotateArr(nums, 0, k-1);
        return rotateArr(nums,k, nums.length-1);
    }

    public static int[] rotateArr(int []arr, int start, int end){

        while(start< end)
        {
            int temp= arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
      return arr;
    }
}
