package com.blind75.array;


/*Given an array of integers nums and
an integer target, return indices of the
two numbers such that they add up to target.
You may assume that each input would have
exactly one solution, and you may not use
the same element twice. You can return the
answer in any order*/

import java.util.Arrays;

/*
    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]
    */
public class TwoSum {

    public static void main(String []args){
        Solution solution = new Solution();
//        int []arr = {3,5,4,2};
//        int target =5;

//        int []arr = {2,7,11,15};
//        int target =9;

//        int []arr = {3,2,4};
//        int target =6;

        int []arr = {3,3};
        int target =6;

       System.out.println(Arrays.toString(solution.twoSum(arr, target)));
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){
            for(int j=i; j<nums.length;j++){

                if(i!=j && nums[i]==target-nums[j]){
                    return new int[] {i,j};
                }
            }
        }

        return new int[] {0,1};
    }
}


/*
Brute Force

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return new int[2];
    }
}
TC - O(n^2)
SC - O(1)

Two Pass with HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for(int i = 0; i < nums.length; i++)
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i]))
                return new int[] {i, map.get(target - nums[i])};

        return new int[2];
    }
}
TC - O(n)
SC - O(n)

One Pass with HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[] {i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }

        return new int[2];
    }
}
 */
