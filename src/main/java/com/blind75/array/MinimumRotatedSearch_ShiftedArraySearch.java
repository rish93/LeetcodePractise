package com.blind75.array;
//TODO Also called Find Minimum in Rotated Sorted Array

/*
* Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
* * For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
* in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 */



// basically find where there is discrepency as this is a sorted array and its just shifted so there will be a point
// where prev > next that is what we have to find here so
// return minimum from the binary tree logic just check for reverse conditions

// Take mid as refernece/Pivot and check if it is in sorted w.r.t mid-1 and mid+1
// 12|3|456  Ideal condition mid[3]>pos[3-1]   mid[3]<mid[3+1]

// TODO But we need to check reverse of sorted and also return minimum of the condition
//TODO  mid[3]<mid[3-1]-> mid[3]  mid[3]>mid[3+1]-> mid[3+1]


import java.util.Arrays;

public class MinimumRotatedSearch_ShiftedArraySearch {
    public static void main(String[] args) {
        //System.out.println(Arrays.asList(tryFAILProductExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 17, 25})));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 17, 25})));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 17, 25})));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 25})));
    }


    public static int binarySearch(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;      // to avoid integer overflow
            if (midpoint > 0 && nums[midpoint] < nums[midpoint - 1])
                return nums[midpoint];

            else if (nums[midpoint] > nums[midpoint + 1])
                return nums[midpoint + 1];
            else if (nums[midpoint] < nums[right])  ///12|3|45
                right = midpoint - 1;
            else if (nums[midpoint] > nums[left])
                left = midpoint + 1;
        }

        return nums[left];
    }


}
