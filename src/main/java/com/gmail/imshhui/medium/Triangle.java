package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @see <a href="https://leetcode.com/problems/triangle/"></a>
 * User: liyulin
 * Date: 2019/8/22
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> bottomList = triangle.get(triangle.size() - 1);
        int[] path = new int[triangle.size()];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < bottomList.size(); i++) {
            path[i] = pathHelper(triangle, triangle.size() - 1, i, map);
        }
        int minimumTotal = Integer.MAX_VALUE;
        for (int i : path) {
            minimumTotal = Math.min(i, minimumTotal);
        }
        return minimumTotal;
    }

    private int pathHelper(List<List<Integer>> triangle, int rowIndex, int i, Map<String, Integer> map) {
        if (rowIndex < 0) {
            return 0;
        }
        // add separator to avoid a.rowIndex=b.i&&a.i=b.rowIndex when there are many Integers in the list
        String key = rowIndex + "@" + i;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        List<Integer> temp = triangle.get(rowIndex);
        int a, b;
        if (i == temp.size() - 1) {
            a = b = pathHelper(triangle, rowIndex - 1, i - 1, map);
        } else {
            a = pathHelper(triangle, rowIndex - 1, i, map);
            b = i - 1 < 0 ? a : pathHelper(triangle, rowIndex - 1, i - 1, map);
        }
        int path = Math.min(a, b) + temp.get(i);
        map.put(key, path);
        return path;
    }
}
