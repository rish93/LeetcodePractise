package com.Practise.Adobe;

//https://leetcode.com/problems/concatenation-of-array/


import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        int []nums={2,34,5,6,7};
        System.out.println(Arrays.toString(concatenateArray(nums)));
    }

    static int[] concatenateArray(int []nums){
        int[] result = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            result[i] = nums[i];
            result[nums.length+i] = nums[i];
        }

        return result;
    }
}
