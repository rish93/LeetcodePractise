package com.blind75.dynamicprograming;

public class PartitionEqualSubsetSum_416 {

    /* * *
    *   Given an integer array nums, return true if you can partition the
    *   array into two subsets such that the sum of the elements in both
    *   subsets is equal or false otherwise.
    *
    *   Example 1:
    *   Input: nums = [1,5,11,5]
    *   Output: true
    *   Explanation: The array can be partitioned as [1, 5, 5] and [11].
    *   Example 2:
    *
    *   Input: nums = [1,2,3,5]
    *   Output: false
    *   Explanation: The array cannot be partitioned into equal sum subsets.
    * * *  */
    public static void main(String[] args) {
        int []nums={1,5,11,5};
        partitionSumArray(nums);
    }
    private static boolean partitionSumArray(int []arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
        }

        if(sum%2!=0)
            return false;

           return subsetSum(arr, sum/2);
    }

    static  boolean  subsetSum(int []arr, int sum){
        //dp size [n+1][sum+1]
        int n=arr.length;
        int [][]dp = new int[n+1][sum+1];
        int []sumArr = new int[sum+1];
        for(int i=0;i<sumArr.length;i++){
            sumArr[i] = i;
        }
             /*
                    *              ----------> sum
                    *           0    1     2     3               4                  5                6                    7                 8               9          10         11
                    *0   0      0    0     0     0               0                  0                0                    0                 0               0          0          0
                    *1   1      0    1     1     1               1                  1                1                    1                 1               1          1          1
                    *2   5      0    1     1     1               1                  5               5 + 1                 5+1              5+1             5+1        5+1        5+1
                    *3   11     0    1     1     1                1                 5                6                    6                 6               6          6          11
                    *4   5      0    1     1     1                1                 5                 5+1                  6                6                6         6          11
                    *
                    * */

        for(int row=0;row<dp.length;row++){
            for(int column=0;column<dp[row].length;column++){
                if(row==0 || column ==0){
                    dp[row][column] = 0;
                }
            }
        }

//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < sum + 1; j++) {
//                if (arr[i - 1] <= j) {
//                    dp[i][j] = Math.max(dp[i - 1][j - arr[i - 1]] , dp[i - 1][j]);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
        print2Dmatrix(dp);
        for(int row=1;row<dp.length;row++){
            for(int column=1;column<dp[row].length;column++) {

                if(sumArr[column]-arr[row]>0)
                    dp[row][column] =  arr[row]+ dp[sumArr[column]-arr[row]][column];
                else if(sumArr[column]<arr[row])
                    dp[row][column] = dp[row-1][column];
            }
        }


        print2Dmatrix(dp);

        return dp[n+1][sum+1]==sum;
    }
    private static void print2Dmatrix(int[][]dp){
        for(int row=0;row<dp.length;row++){
            for(int column=0;column<dp[row].length;column++) {
                System.out.print(dp[row][column]+", ");
            }

            System.out.println();
        }
    }
}
