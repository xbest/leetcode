package com.gmail.imshhui.hard;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * @see <a href="https://leetcode.com/problems/first-missing-positive/"></a>
 * User: liyulin
 * Date: 2019/7/19
 */
// TODO not resolved yet
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int minPositive = Integer.MAX_VALUE;
        int min2Positive = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                minPositive = minPositive < nums[i] ? minPositive : nums[i];
                if (nums[i] > minPositive && nums[i] < min2Positive) {
                    min2Positive = nums[i];
                }
            }
        }
        return 0;
    }
}
