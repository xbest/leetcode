package com.gmail.imshhui.medium;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 * @see <a href="https://leetcode.com/problems/single-number-ii/"></a>
 * User: liyulin
 * Date: 2019/9/16
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i = i + 3) {
            if (nums[i] != nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
