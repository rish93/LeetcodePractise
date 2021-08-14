package com.blind75.array;

import java.util.Arrays;

public class BinarySearch {


    public static void main(String[] args) {

        //System.out.println(Arrays.asList(tryFAILProductExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 17, 25}, 17)));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 17, 25}, 7)));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 17, 25}, 10)));
        System.out.println(Arrays.asList(binarySearch(new int[]{6, 7, 8, 9, 10, 12, 25}, 1)));
    }


    public static int binarySearch(int[] nums, int target) {
        //1st search midpoint
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] == target)
                return nums[midpoint];

            else if (target < nums[midpoint]) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }
        return -1;

    }

}
