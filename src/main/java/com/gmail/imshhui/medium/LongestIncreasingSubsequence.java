package com.gmail.imshhui.medium;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n^2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 * User: liyulin
 * Date: 2019/10/16
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthOfLIS(int[] nums, int pre, int pos) {
        if (pos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[pos] > pre) {
            taken = 1 + lengthOfLIS(nums, nums[pos], pos + 1);
        }
        int notTaken = lengthOfLIS(nums, pre, pos + 1);
        return Math.max(taken, notTaken);
    }


    public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // bad case: [2,2] while max=1 not max=2
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] = dp[i] + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
