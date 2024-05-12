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
// works on a sorted array
    // go from 0 to end find mid in every loop close down left and right based on target >  = < mid

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


    /*
    How to take out mid
    low + high) / 2: The sum of the left and right indices is divided by 2 to get the mid point.
    The problem with this is that the sum could overflow.
     If the sum is an even number, we pick the lower one.
      Example - With left and right as [2, 5] - We pick mid as 3

    l + (r - l) / 2: The difference between the right and the left index
    is found and is divided by 2. It is then added to the left index to
     find the midpoint. It might be easier to visualize this with an example.
    Example : [5, 11] -> (11 - 5) / 2 = 3 The middle in this interval is now
     3 places or hops from the left index. So, add the left index to find the
     index of the mid element which is 5 + 3 = 8

    */
}
