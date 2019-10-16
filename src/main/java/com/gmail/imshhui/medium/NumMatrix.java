package com.gmail.imshhui.medium;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 * @see <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">304. Range Sum Query 2D - Immutable</a>
 * User: liyulin
 * Date: 2019/10/16
 */
public class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix != null && matrix.length > 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            sumMatrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sumMatrix[i][j] = sum(matrix, i, j);
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (col1 - 1 < 0 && row1 - 1 < 0) {
            return sumMatrix[row2][col2];
        }
        if (col1 - 1 < 0) {
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2];
        }
        if (row1 - 1 < 0) {
            return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1];

        }
        return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1] - sumMatrix[row1 - 1][col2] + sumMatrix[row1 - 1][col1 - 1];
    }

    private int sum(int[][] matrix, int x, int y) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
