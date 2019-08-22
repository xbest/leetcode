package com.gmail.imshhui.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/pascals-triangle/"></a>
 * User: liyulin
 * Date: 2019/8/22
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        triangleHelper(list, numRows - 1);
        return list;
    }

    private void triangleHelper(List<List<Integer>> list, int numRows) {
        if (numRows == -1) {
            return;
        }
        if (numRows == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            list.add(temp);
            return;
        }
        triangleHelper(list, numRows - 1);
        List<Integer> pre = new ArrayList<>(list.get(numRows - 1));
        pre.add(0, 0);
        pre.add(pre.size(), 0);
        List<Integer> temp = new ArrayList<>(pre.size() - 1);
        for (int i = 0; i < pre.size() - 1; i++) {
            temp.add(pre.get(i) + pre.get(i + 1));
        }
        list.add(temp);
    }

    private void triangleHelper1(List<List<Integer>> list, int numRows) {
        if (numRows == 0) {
            list.add(Arrays.asList(1));
        } else if (numRows > 0) {
            triangleHelper(list, numRows - 1);
            List<Integer> pre = new ArrayList<>(list.get(numRows - 1));
            pre.add(0, 0);
            pre.add(pre.size(), 0);
            List<Integer> temp = new ArrayList<>(pre.size() - 1);
            for (int i = 0; i < pre.size() - 1; i++) {
                temp.add(pre.get(i) + pre.get(i + 1));
            }
            list.add(temp);
        }
    }
}
