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

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BestTimeToBuySellStock {
    static {
        System.out.println("starting..");
    }
    public static void main(String []args){
       int[] priceList = new int[]{1,8,2,34,7};


       int outputResult= maxProfit(priceList);
       System.out.println(outputResult);
    }

/*map<>
  Entry  1   max =0
        2    max (0, 2-1)

   */

    //for every iteration takes out minimum value cz minimum price is required to find MAX profit
    //then check for present profit and assign it to max if you find it maximum.
        static int maxProfit(int priceList[])
        {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < priceList.length; i++) {
                if (priceList[i] < minprice)
                    minprice = priceList[i];
                else if (priceList[i] - minprice > maxprofit)
                    maxprofit = priceList[i] - minprice;
            }
            return maxprofit;
        }


    public int brutteForceApproach(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

}





