package com.blind75.array;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
Return the maximum profit you
can achieve from this transaction.
If you cannot achieve any profit, return 0.
 */

/*
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */

//https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
public class BestTimeToBuySellStock {
    static {
        System.out.println("starting..");
    }
    public static void main(String []args){
       int[] arr = new int[]{2,4,5,1,7};
       int outputResult= maxProfit(arr, arr.length);
       System.out.println(outputResult);
    }



        // Returns maximum profit
        // with two transactions on a
        // given list of stock prices,
        // price[0..n-1]
        static int maxProfit(int price[], int n)
        {
            // Create profit array
            // and initialize it as 0
            int profit[] = new int[n];
            for (int i = 0; i < n; i++)
                profit[i] = 0;

        /* Get the maximum profit
           with only one transaction
           allowed. After this loop,
           profit[i] contains
           maximum profit from
           price[i..n-1] using at most
           one trans. */
            int max_price = price[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                // max_price has maximum
                // of price[i..n-1]
                if (price[i] > max_price)
                    max_price = price[i];

                // we can get profit[i]
                // by taking maximum of:
                // a) previous maximum,
                // i.e., profit[i+1]
                // b) profit by buying
                // at price[i] and selling
                // at
                //    max_price
                profit[i] = Math.max(profit[i + 1],
                        max_price - price[i]);
            }

        /* Get the maximum profit
           with two transactions allowed
           After this loop, profit[n-1]
           contains the result
         */
            int min_price = price[0];
            for (int i = 1; i < n; i++) {
                // min_price is minimum
                // price in price[0..i]
                if (price[i] < min_price)
                    min_price = price[i];

                // Maximum profit is maximum of:
                // a) previous maximum, i.e., profit[i-1]
                // b) (Buy, Sell) at (min_price, price[i]) and
                // add
                // profit of other trans.
                // stored in profit[i]
                profit[i] = Math.max(
                        profit[i - 1],
                        profit[i] + (price[i] - min_price));
            }
            int result = profit[n - 1];
            return result;
        }

}





