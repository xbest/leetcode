package com.gmail.imshhui.medium;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Note:
 You may assume that you have an infinite number of each kind of coin.

 @see <a href="https://leetcode.com/problems/coin-change/"></a>
  *
  * User: liyulin
  * Date: 2019/10/21
 */
public class CoinChange {
    public int coinChangeTimeLimitExceeded(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] min = new int[]{Integer.MAX_VALUE};
        backtrace(coins, min, 0, amount);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    private void backtrace(int[] coins, int[] min, int cur, int amount) {
        if (amount == 0) {
            min[0] = Math.min(min[0], cur);
        }
        if (amount < 0) {
            return;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            backtrace(coins, min, cur + 1, amount - coins[i]);
        }
    }
}
