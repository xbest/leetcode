package com.gmail.imshhui.easy;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,1,2,11]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * @see <a href="https://leetcode.com/problems/house-robber/"></a>
 * User: liyulin
 * Date: 2019/9/25
 */
public class HouseRobber {
    public int rob(int[] nums) {
        return robHelper(nums, nums.length - 1);
    }

    private int robHelper(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(robHelper(nums, i - 1), robHelper(nums, i - 2) + nums[i]);
    }

    public int robMemo(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robMemoHelper(nums, nums.length - 1, memo);
    }

    private int robMemoHelper(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(robMemoHelper(nums, i - 1, memo), robMemoHelper(nums, i - 2, memo) + nums[i]);
        memo[i] = result;
        return result;
    }
}
