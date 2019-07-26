package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * <p>
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/"></a>
 * User: liyulin
 * Date: 2019/7/26
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<String, Integer> visited = new HashMap<>();
        return backtrace(visited, obstacleGrid, 0, 0);
    }

    private int backtrace(Map<String, Integer> visited, int[][] obstacleGrid, int i, int j) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        if (i >= rows || j >= columns || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        String key;
        int n1 = 0, n2 = 0;
        if (i < rows) {
            key = (i + 1) + "@" + j;
            if (visited.containsKey(key)) {
                n1 = visited.get(key);
            } else {
                n1 = backtrace(visited, obstacleGrid, i + 1, j);
            }
        }
        if (j < columns) {
            key = i + "@" + (j + 1);
            if (visited.containsKey(key)) {
                n2 = visited.get(key);
            } else {
                n2 = backtrace(visited, obstacleGrid, i, j + 1);
            }
        }
        visited.put(i + "@" + j, n1 + n2);
        return n1 + n2;
    }
}
