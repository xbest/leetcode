package com.gmail.imshhui.medium;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 * @see <a href="https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/">462. Minimum Moves to Equal Array Elements II</a>
 * User: liyulin
 * Date: 2020/1/17
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int moves = 0;
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            moves = moves + Math.abs(nums[i] - mid);
        }
        return moves;
    }
}
