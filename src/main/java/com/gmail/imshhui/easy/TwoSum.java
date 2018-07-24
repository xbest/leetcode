package com.gmail.imshhui.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumTwopassHashmap(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = numsMap.get(target - nums[i]);
            if (Objects.nonNull(index) && index != i) {
                return new int[]{i, index};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumOnepassHashmap(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
            Integer index = numsMap.get(target - nums[i]);
            if (Objects.nonNull(index) && index != i) {
                return new int[]{index, i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
