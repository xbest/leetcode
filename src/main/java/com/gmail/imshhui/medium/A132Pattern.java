package com.gmail.imshhui.medium;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 * Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 *
 * Note: n will be less than 15,000.
 *
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 *
 * Example 2:
 * Input: [3, 1, 4, 2]
 * Output: True
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * Output: True
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * @see <a href="https://leetcode.com/problems/132-pattern/">456. 132 Pattern</a>
 * User: liyulin
 * Date: 2020/1/13
 */
public class A132Pattern {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
//                    bad case: [1, 0, 1, -4, -3]
//                    if (nums[i] < nums[j] && nums[j] > nums[k]) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
