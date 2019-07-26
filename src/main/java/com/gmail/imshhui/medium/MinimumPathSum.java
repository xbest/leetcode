package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/"></a>
 * User: liyulin
 * Date: 2019/7/26
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        Map<String, Integer> visited = new HashMap<>();
        return backtrace(visited, grid, 0, 0);
    }

    private int backtrace(Map<String, Integer> visited, int[][] grid, int i, int j) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (i >= rows || j >= columns) {
            return Integer.MAX_VALUE;
        }
        if (i == rows - 1 && j == columns - 1) {
            return grid[i][j];
        }
        String key;
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        if (i < rows) {
            key = (i + 1) + "@" + j;
            if (visited.containsKey(key)) {
                n1 = visited.get(key);
            } else {
                n1 = backtrace(visited, grid, i + 1, j);
            }
        }
        if (j < columns) {
            key = i + "@" + (j + 1);
            if (visited.containsKey(key)) {
                n2 = visited.get(key);
            } else {
                n2 = backtrace(visited, grid, i, j + 1);
            }
        }
        visited.put(i + "@" + j, Math.min(n1, n2) + grid[i][j]);
        return Math.min(n1, n2) + grid[i][j];
    }
}
