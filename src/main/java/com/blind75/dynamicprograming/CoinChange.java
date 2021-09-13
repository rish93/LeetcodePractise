package com.blind75.dynamicprograming;

/*
  You are given an integer array coins representing coins
  of different denominations and an integer amount representing a total
  amount of money. Return the fewest number of coins that you need to
  make up that amount. If that amount of money cannot be made up by any
  combination of the coins, return -1. You may assume that you have an
  infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0


Example 4:
Input: coins = [1], amount = 1
Output: 1

Example 5:
Input: coins = [1], amount = 2
Output: 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
        Integer result = -1;


    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount=11;
        CoinChange coinChange = new CoinChange();
        int length = coins.length;

        System.out.println(coinChange.coinChange(coins,amount,length));
    }


    public int coinChange(int[] coins, int amount, int length) {
        Arrays.sort(coins);
        while((length-1)>=0){
            if (amount -coins[length-1]> 0) {
                coinChange(coins, amount , length);
                result++;
            }
        }
        return result;
    }
}
