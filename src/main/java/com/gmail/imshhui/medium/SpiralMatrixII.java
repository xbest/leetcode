package com.gmail.imshhui.medium;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/"></a>
 * User: liyulin
 * Date: 2019/7/24
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int element = 1;
        int i = 0, j = 0;
        while (element <= n * n) {
            while (j < n && matrix[i][j] == 0) {
                matrix[i][j] = element;
                element++;
                j++;
            }
            j--;
            i++;
            while (i < n && matrix[i][j] == 0) {
                matrix[i][j] = element;
                element++;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = element;
                element++;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = element;
                element++;
                i--;
            }
            i++;
            j++;
        }
        return matrix;
    }
}
