package com.gmail.imshhui.medium;

import java.util.Arrays;

/**
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 *
 * @see <a href="https://leetcode.com/problems/next-greater-element-ii/">503. Next Greater Element II</a>
 * User: liyulin
 * Date: 2020/2/18
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < res.length; i++) {
            int j = (i + 1) % nums.length;
            while (true) {
                if (nums[j] > res[i]) {
                    res[i] = nums[j];
                    break;
                }
                if (j == i) {
                    res[i] = -1;
                    break;
                }
                j = (j + 1) % nums.length;
            }
        }
        return res;
    }
}
