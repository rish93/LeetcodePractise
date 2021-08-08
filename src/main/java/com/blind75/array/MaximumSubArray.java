package com.blind75.array;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1]
has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 */

public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(containsMaximumSubArray (new int[]{-2,1,-3,4,-1,2,1,-5,4}));  //6
        System.out.println(containsMaximumSubArray(new int[]{1})); //1
        System.out.println(containsMaximumSubArray(new int[]{5,4,-1,7,8})); //23
        System.out.println(containsMaximumSubArray(new int[]{-1})); //-1
        System.out.println(containsMaximumSubArray(new int[]{-2,-1})); //-1
        System.out.println(containsMaximumSubArray(new int[]{-2,1})); //1
    }

    public static Integer containsMaximumSubArray(int[] nums) {
        if(nums.length==1)
            return nums[0];

        int pointer_b=0;
        int max = 0;
        int sum = 0;
        while(pointer_b<nums.length){
            sum+=nums[pointer_b];
            if (sum < 0) {
                sum = 0;
            }
        if(max<sum)
            max =sum;

            pointer_b++;
        }
        return max;
    }
}
