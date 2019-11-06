package com.gmail.imshhui.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/"></a>
 * User: liyulin
 * Date: 2019/11/6
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));
        for (int j = 0; j < matrix[0].length; j++) {
            queue.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = queue.poll();
            if (t.i == matrix.length - 1) {
                continue;
            }
            queue.offer(new Tuple(t.i + 1, t.j, matrix[t.i + 1][t.j]));
        }
        return queue.poll().val;
    }

    private class Tuple {
        private int i;
        private int j;
        private int val;

        public Tuple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
