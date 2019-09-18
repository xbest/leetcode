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

    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int global = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            min = Math.min(min * nums[i], Math.min(nums[i], temp * nums[i]));
            global = Math.max(global, max);
        }
        return global;
    }

}
