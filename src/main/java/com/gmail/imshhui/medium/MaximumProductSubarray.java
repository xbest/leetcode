package com.gmail.imshhui.medium;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @see <a href="https://leetcode.com/problems/maximum-product-subarray/"></a>
 * User: liyulin
 * Date: 2019/9/18
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int step = 1; step <= nums.length; step++) {
            for (int i = 0; i < nums.length - step + 1; i++) {
                int value = 1;
                for (int j = i; j < step + i; j++) {
                    value = value * nums[j];
                }
                max = Math.max(max, value);
            }
        }
        return max;
    }

}
