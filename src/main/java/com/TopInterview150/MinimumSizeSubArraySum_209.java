package com.TopInterview150;

public class MinimumSizeSubArraySum_209 {


    //https://www.youtube.com/watch?v=gReqI3hMQCQ
    /*
    *
    *
    * 209. Minimum Size Subarray Sum
    * Medium
    Topics
    Companies

    Given an array of positive integers nums and a positive integer target, return the minimal length of a
    subarray
    whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



    Example 1:

    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.

    Example 2:

    Input: target = 4, nums = [1,4,4]
    Output: 1

    Example 3:

    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0



    Constraints:

    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104
    *
    * */
    public static void main(String[] args) {
//        int[] arr={2,3,6,1,7,5,4};
        int[] arr={1,4,2,1,3,2,1,1,5,4};
        int target = 7;
        System.out.println( minSubArraySum(arr, target));
      //minSubArraySumKadaneAlgo(arr, target);
    }

//    private static void minSubArraySumKadaneAlgo(int []arr, int target) {
//        int min =Integer.MAX_VALUE;
//        int sum =Integer.MIN_VALUE;;
//        for (int i=0;i< arr.length;i++) {
//            sum =  Math.min(arr[i]-min, sum);
//            min =  Math.min(min,sum);
//        }
//    System.out.println(min);
//    }
    private static int minSubArraySum(int []arr, int target){
        int pointer_a = 0;
        int pointer_b = 0;
        int ans = Integer.MAX_VALUE;
        int sum =0;
        for(int i=0;i<arr.length;i++) {
              pointer_b = i;
              sum += arr[pointer_b];
//            pointer_b++;
//            if(sum >= target ) {
                while(sum >= target && pointer_b< arr.length) {
                      ans = Math.min(ans, pointer_b - pointer_a + 1);
//                    pointer_b-=i;
                      sum -=arr[pointer_a++];
                }
//            }
        }
        return ans!=Integer.MAX_VALUE?ans:0;
    }
}
