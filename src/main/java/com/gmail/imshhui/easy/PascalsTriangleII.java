package com.gmail.imshhui.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/"></a>
 * User: liyulin
 * Date: 2019/8/22
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        return triangleHelper(rowIndex);
    }

    private List<Integer> triangleHelper(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        List<Integer> pre = triangleHelper(rowIndex - 1);
        List<Integer> temp = new ArrayList<>(rowIndex + 1);
        temp.add(1);
        for (int i = 0; i < pre.size() - 1; i++) {
            temp.add(pre.get(i) + pre.get(i + 1));
        }
        temp.add(1);
        return temp;
    }
}
