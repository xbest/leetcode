package com.gmail.imshhui.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 * @see <a href="https://leetcode.com/problems/number-of-boomerangs/">447. Number of Boomerangs</a>
 * User: liyulin
 * Date: 2019/11/29
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                int d = getDistance(p1, p2);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (Integer value : map.values()) {
                res = res + value * (value - 1);
            }
            map.clear();
        }
        return res;
    }

    private int getDistance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return x * x + y * y;
    }
}
