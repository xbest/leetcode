package com.gmail.imshhui.easy;

/**
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * @see <a href="https://leetcode.com/problems/minimum-moves-to-equal-array-elements/">453. Minimum Moves to Equal Array Elements</a>
 * User: liyulin
 * Date: 2019/12/3
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res = res + num - min;
        }
        return res;
    }
}
