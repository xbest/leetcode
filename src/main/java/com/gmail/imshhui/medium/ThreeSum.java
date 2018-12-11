package com.gmail.imshhui.medium;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * User: liyulin
 * Date: 2018/9/27
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip the same numbers
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    }
                    if (nums[i] + nums[start] + nums[end] > 0) {
                        int currentEnd = end;
                        while (nums[currentEnd] == nums[end] && start < end) {
                            end--;
                        }
                    } else {
                        int currentStart = start;
                        while (nums[currentStart] == nums[start] && start < end) {
                            start++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
