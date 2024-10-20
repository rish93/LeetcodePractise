package com.blind75.dynamicprograming;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300

{
    public static void main(String[] args) {


        System.out.println(lengthOfLIS(new int[]{2,4,6,1,6,7}));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Initialize all dp[i] to 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLIS = 0;
        for (int length : dp) {
            maxLIS = Math.max(maxLIS, length);
        }
        return maxLIS;
    }
}
