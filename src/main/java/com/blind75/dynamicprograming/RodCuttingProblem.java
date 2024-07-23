package com.blind75.dynamicprograming;

import java.util.Arrays;

public class RodCuttingProblem {

    /*Given a rod of length N inches and an array of prices,
    price[]. price[i] denotes the value of a piece of length i.
     Determine the maximum value you can obtain by cutting up
     the whole rod and selling the pieces.
    Note: Consider 1-based indexing.

    N = 8
    Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
    Output: 22
    Explanation: The maximum obtainable value is 22 by cutting in
    two pieces of lengths 2 and 6, i.e., 5+17=22.
    * */


    public static void main(String[] args) {

        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "
                + cutRod(arr, size));

         System.out.println("Maximum Obtainable Value is "
                + cutRodDpProblem(arr, size));

    }

    private static String cutRodDpProblem(int[] priceArr, int size) {

                    int lengthArr[]=new int[size+1];
                    for(int i=0;i<=size;i++){
                        lengthArr[i]=i;
                    }
                    System.out.println(Arrays.toString(lengthArr));
                    int dp[][]= new int[priceArr.length+1][size+1];
                    for(int row=0;row< dp.length;row++){
                        for(int column=0;column<dp[row].length;column++){
                                if(row==0 || column==0){
                                    dp[row][column] = 0;
                                }
                        }
                    }

//                 int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20};
//                 int size = arr.length;

                    /*
                    *              ----------> length (i)
                    *           0    1     2     3               4                  5                6                    7                 8
                    *0   0      0    0     0     0               0                  0                0                    0                 0
                    *1   1      0    1     1     1               1                  1                1                    1                 1
                    *2   5      0    1     5    max( 1, 5+1)    max( 1, 5+1)        max( 1, 5+1)    max( 1, 5+1)          max( 1, 5+1)      max( 1, 5+1)
                    *3   8      0    1     5    max (6, 8 +0)   max (6, 8 + 1)      max (6, 8+5)    max (6, 8 +5+1 )      max (6, 8 +5+1)   max (6, 8 +5+1)
                    *4   9      0    1     5    8               max(9, 9)           max(13, 9+1)    max(14, 9+5)          max(14, 9+8)         max(14, 9+8+1)
                    *5   10     0    1     5    8               9                   max(13, 10)     max(14, 10+1))        max(9, 10+5))     max(9, 10+8))
  //prices |        *6   17     0    1     5    8               9                   13              max(11, 17)           max(15, 17+1)     max(18, 17+5)
inches     |        *7   17     0    1     5    8               9                   13              17                    max(18, 17)       max(22, 17+1)
                    *8   20     0    1     5    8               9                   13              17                     18               max(22, 20) =   22
                    *
                    *
                    * */
                for(int row=1;row<dp.length;row++){
                    for(int column=1;column<dp[row].length;column++) {
                        // lengthArr   0-8
                        // priceArr    0-8
                        // if length is less than available length/price
                        // copy from last row/ take last row or lenght/price value
                        if(lengthArr[column] < (row)){
                            dp[row][column] = dp[row-1][column];
                        } else {
                            dp[row][column] = Math.max(dp[row-1][column], priceArr[row-1]+ dp[column-row][column]);
                        }
                    }


                }
                         print2Dmatrix(dp);

                     return "ans: "+dp[priceArr.length][size];
            }


    private static void print2Dmatrix(int[][]dp){
        for(int row=0;row<dp.length;row++){
            for(int column=0;column<dp[row].length;column++) {
                System.out.print(dp[row][column]+", ");
            }

            System.out.println();
        }
    }

    /* Returns the best obtainable price for a rod of length
       n and price[] as prices of different pieces */
    static int cutRod(int price[], int n)
    {
        int sum = 0;
        if(n==0)
            return 0;
        for(int i=0;i<n;i++){

           sum+=  price[i] + Math.max(cutRod(price, n-1), sum);


        }

        return sum;
    }

}
