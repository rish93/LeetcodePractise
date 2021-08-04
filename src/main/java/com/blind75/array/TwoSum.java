package com.blind75.array;


/*Given an array of integers nums and
an integer target, return indices of the
two numbers such that they add up to target.
You may assume that each input would have
exactly one solution, and you may not use
the same element twice. You can return the
answer in any order*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

        int []arr = {4,9,34,2,0,6,8,1,5};
        int target =15;
        //brutte force approach
       // System.out.println(Arrays.toString(solution.brutteForceTwoSum(arr, target)));

       //using hashmap/java object
        System.out.println(Arrays.toString(   solution.linearComplexityTwoSum(arr, target)));

    }
}
//constant O(N)
//linear  O(1)
//exponential O(N2))
//Logarithmic O(Logn)
class Solution {

    public int[] linearComplexityTwoSum(int[] numbers, int target) {

            int[] result = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {   //O(n)
                if (map.containsKey(target - numbers[i])) {  //O1
                    result[1] = i;  //O1
                    result[0] = map.get(target - numbers[i]);  //O1
                    return result;
                }
                map.put(numbers[i], i);
            }
            return result;

    }



    public int[] brutteForceTwoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i; j<nums.length;j++){  //O(n2)
                if(i!=j && nums[i]+nums[j]==target){  //0(1)
                    return new int[] {i,j};  //O(1)
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
