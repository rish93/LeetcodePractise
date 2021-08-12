package com.blind75.array;


/*
* Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

* Example 1:
* Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

* Example 2:
* Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray*/


public class MaximumProductOfSubArray {

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maximumProduct(new int[]{-2, 3, -4}));
        System.out.println(maximumProduct(new int[]{-5, 1, 2, 3, -6}));
        System.out.println(maximumProduct(new int[]{3, -1, 4}));

    }

    public static Integer maximumProduct(int[] A) {
        int totalMax = Integer.MIN_VALUE;
        int maxTillNow = 1;
        int pointer_a = 0;
        while (pointer_a < A.length) {
            maxTillNow *= A[pointer_a];
            /*if(maxTillNow < A[pointer_a] )
                maxTillNow=A[pointer_a];*/
            if (maxTillNow > totalMax) {
                totalMax = maxTillNow;
            }
            if (maxTillNow == 0)
                maxTillNow = 1;

            pointer_a++;
        }

        //
        maxTillNow = 1;

        pointer_a = A.length - 1;
        while (pointer_a >= 0) {
            maxTillNow *= A[pointer_a];

            /*if(maxTillNow < A[pointer_a] )
                maxTillNow=A[pointer_a];*/
            if (maxTillNow > totalMax) {
                totalMax = maxTillNow;
            }
            if (maxTillNow == 0)
                maxTillNow = 1;

            pointer_a--;
        }


        return totalMax;
    }


    /*
     * {-2,3,-4,}
     *
     *  {-5,1,2,3,-6}
     *
     *
     *
     * */

}
