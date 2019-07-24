package com.gmail.imshhui.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/"></a>
 * User: liyulin
 * Date: 2019/7/23
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp = temp + nums[j];
                tempSum = tempSum > temp ? tempSum : temp;
            }
            sum = sum > tempSum ? sum : tempSum;
        }
        return sum;
    }

    public int maxSubArrayOn(int[] nums) {
        int maxSofar = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            maxSofar = Math.max(maxEnding, maxSofar);
        }
        return maxSofar;
    }
}
