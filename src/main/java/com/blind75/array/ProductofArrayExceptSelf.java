package com.blind75.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an int array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit int.

        You must write an algorithm that runs in O(n) time and without using the division operation.



        Example 1:

        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]*/
public class ProductofArrayExceptSelf {

    public static void main(String[] args) {

        //System.out.println(Arrays.asList(tryFAILProductExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.asList(tryMapProductExceptSelf(new int[]{6,7,8,9})));
    }


    public static int[] tryFAILProductExceptSelf(int[] nums) {

        int totalProduct = 1;
        int[] answer = new int[nums.length];
        for (int num : nums) {
            if (num == 0)
                num = 1;
            totalProduct *= num;

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                answer[i] = totalProduct / 1;
            else
                answer[i] = totalProduct / nums[i];
        }
        return answer;
    }

    public static int[] tryMapProductExceptSelf(int[] nums) {

        // Left is an array containing the left products
        // i.e: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        int[] left = new int[nums.length];

        // Right is an array containing the array products
        //i.e: right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
        int[] right = new int[nums.length];


        //[6,7,8,9] -->  left[]  =[1,6,42,336]          right[length-1]=[504,72,9,1]


        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] product = new int[nums.length];
        for (int i = 0; i < product.length; i++) {
            product[i] = left[i] * right[i];
        }

        return product;
    }
}
