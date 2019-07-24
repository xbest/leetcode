package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 、
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix/"></a>
 * User: liyulin
 * Date: 2019/7/24
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length == 0) {
            return ret;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0, j = 0; i < rows && j < columns; i++, j++) {
            int m = i, n = j;
            while (n < columns && !visited[m][n]) {
                ret.add(matrix[m][n]);
                visited[m][n] = true;
                n++;
            }
            m++;
            n--;
            while (m < rows && !visited[m][n]) {
                ret.add(matrix[m][n]);
                visited[m][n] = true;
                m++;
            }
            n--;
            m--;
            while (n >= 0 && !visited[m][n]) {
                ret.add(matrix[m][n]);
                visited[m][n] = true;
                n--;
            }
            m--;
            n++;
            while (m >= 0 && !visited[m][n]) {
                ret.add(matrix[m][n]);
                visited[m][n] = true;
                m--;
            }
        }
        return ret;
    }
}
