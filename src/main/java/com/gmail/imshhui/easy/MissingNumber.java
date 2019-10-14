package com.gmail.imshhui.easy;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @see <a href="https://leetcode.com/problems/missing-number/"></a>
 * User: liyulin
 * Date: 2019/10/14
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        //bad case: [0], [0,1], [1,2], [2,0]
        if (nums == null || nums.length == 0 || (nums.length >= 1 && nums[0] == 1)) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
