package com.blind75.dynamicprograming;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(2));
        //System.out.println(climbStairs(8));
        //System.out.println(climbStairs(9));
       System.out.println(dpClimbStairs(3));
        System.out.println(dpClimbStairs(5));
    }


    public static int dpClimbStairs(int n){
        int dp[] =new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }


        return dp[n];
    }


    //n=3
    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        int ans = rec(n, memo);
        return ans;
    }

    private static int rec(int n, int memo[]) {
        if (n <= 1) return 1;   //n=1; 1 n=0 0
        if (memo[n] > 0) return memo[n];
        int op1 = rec(n - 1, memo);   // because we can take only 1 or 2 steps at a time
        int op2 = rec(n - 2, memo);  // because we can take only 1 or 2 steps at a time
        memo[n] = op1 + op2;
        return op1 + op2;
    }
}
