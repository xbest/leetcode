package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 *
 * @see <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">417. Pacific Atlantic Water Flow</a>
 * User: liyulin
 * Date: 2019/11/18
 */
public class PacificAtlanticWaterFlow {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(matrix, Integer.MIN_VALUE, i, 0, pacific);
            dfs(matrix, Integer.MIN_VALUE, i, cols - 1, atlantic);
        }
        for (int j = 0; j < cols; j++) {
            dfs(matrix, Integer.MIN_VALUE, 0, j, pacific);
            dfs(matrix, Integer.MIN_VALUE, rows - 1, j, atlantic);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int height, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < height) {
            return;
        }
        visited[i][j] = true;
        for (int[] ints : dir) {
            dfs(matrix, matrix[i][j], i + ints[0], j + ints[1], visited);
        }
    }
}
