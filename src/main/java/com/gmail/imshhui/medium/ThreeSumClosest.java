package com.gmail.imshhui.medium;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * <p>
 * User: liyulin
 * Date: 2018/12/13
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        if (nums.length <= 3) {
            for (int num : nums) {
                result += num;
            }
            return result;
        }
        result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) <= Math.abs(result - target)) {
                    result = sum;
                    if (result == target) {
                        return result;
                    }
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
