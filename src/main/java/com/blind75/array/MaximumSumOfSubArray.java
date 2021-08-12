package com.blind75.array;

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

public class MaximumSumOfSubArray {

    public static void main(String[] args) {
        System.out.println(containsMaximumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));  //6
        System.out.println(containsMaximumSubArray(new int[]{1})); //1
        System.out.println(containsMaximumSubArray(new int[]{5, 4, -1, 7, 8})); //23
        System.out.println(containsMaximumSubArray(new int[]{-1})); //-1
        System.out.println(containsMaximumSubArray(new int[]{-2, -1})); //-1
        System.out.println(containsMaximumSubArray(new int[]{-2, 1})); //1


        System.out.println(kadaneAlgorithm(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));  //6
        System.out.println(kadaneAlgorithm(new int[]{1})); //1
        System.out.println(kadaneAlgorithm(new int[]{5, 4, -1, 7, 8})); //23
        System.out.println(kadaneAlgorithm(new int[]{-1})); //-1
        System.out.println(kadaneAlgorithm(new int[]{-2, -1})); //-1
        System.out.println(kadaneAlgorithm(new int[]{-2, 1})); //1

    }

    public static Integer containsMaximumSubArray(int[] nums) {
        int pointer_b = 0;
        int totalMax = Integer.MIN_VALUE;
        int maxTillNow = 0;
        while (pointer_b < nums.length) {
            maxTillNow += nums[pointer_b];

            if (maxTillNow > totalMax)
                totalMax = maxTillNow;

            if (maxTillNow < 0)
                maxTillNow = 0;

            pointer_b++;
        }
        return totalMax;

    }


    public static int kadaneAlgorithm(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
