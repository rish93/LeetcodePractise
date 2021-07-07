package com.Oct1Week;

/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.



Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs

*/


//https://www.youtube.com/watch?v=S1HZpd8Jhyw


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class kDiffPairsInArray {


    public static void main(String []args){
       Solution solution;

int arr[] = new int[]{1,2,3,4,5};
int k=1;
        solution= new  kDiffPairsInArray.Solution();

        System.out.println(solution.findPairs(arr,k));
    }


    static class Solution{

        public int findPairs(int[] nums, int k) {

            Set<Integer> uniquePairsSet= new HashSet();
            Arrays.sort(nums);
            int n=nums.length;

            for(int i=0; i<n;i++){
                if(Arrays.binarySearch(nums, i+1, n, nums[i]+k)>0)
                {
                    uniquePairsSet.add(Math.min(nums[i], nums[i]+k));
                }
            }

            return uniquePairsSet.size();
        }


    }

}


