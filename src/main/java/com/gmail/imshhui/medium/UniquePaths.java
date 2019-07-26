package com.gmail.imshhui.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 *
 * @see <a href="https://leetcode.com/problems/unique-paths/"></a>
 * User: liyulin
 * Date: 2019/7/26
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] way = new int[1];
        backtrace(way, 0, 0, m, n);
        return way[0];
    }

    private void backtrace(int[] way, int i, int j, int m, int n) {
        if (i > m - 1 || j > n - 1) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            way[0]++;
            return;
        }
        if (i <= m - 1) {
            backtrace(way, i + 1, j, m, n);
        }
        if (j <= n - 1) {
            backtrace(way, i, j + 1, m, n);
        }
    }
}
