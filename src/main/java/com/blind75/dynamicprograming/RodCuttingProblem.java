package com.blind75.dynamicprograming;

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
                + cutRod(arr, size - 1, size));

    }
    /* Returns the best obtainable price for a rod of length
       n and price[] as prices of different pieces */
    static int cutRod(int price[], int index, int n)
    {
        int sum = 0;
        if(n==0)
            return 0;
        for(int i=0;i<n;i++){

           sum+=  price[i] + Math.max(cutRod(price, i, n-1), sum);


        }

        return sum;
    }

}
