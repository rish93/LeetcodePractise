package com.TopInterview150.hackerearthtest;

public class NumberOfWaysToReachStair {

    /*
    * Hacker is a newborn baby, his foot can jump up to 2 stairs. Hacker wants to climb the terrace and n number of stairs. How many distinct ways to climb to the terrace.
    *  > The first line contains N is denoting the number of stairs.
    * *
     > Print number of distinct way to climb the terrace
     * *
    * * * */

    public static void main(String[] args) {
       System.out.println( calculateNumberOfWays(5));
    }

    static int calculateNumberOfWays(int n){
        if(n==1)
            return 1;
        int []dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

}
