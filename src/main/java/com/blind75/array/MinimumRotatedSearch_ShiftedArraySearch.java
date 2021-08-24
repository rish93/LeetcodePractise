package com.blind75.array;
//TODO Also called Find Minimum in Rotated Sorted Array

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
