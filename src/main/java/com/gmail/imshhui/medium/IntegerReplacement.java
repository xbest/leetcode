package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n and you can do operations as follow:
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * Example 1:
 *
 * Input:
 * 8
 *
 * Output:
 * 3
 *
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * Example 2:
 *
 * Input:
 * 7
 *
 * Output:
 * 4
 *
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 * @see <a href="https://leetcode.com/problems/integer-replacement/">397. Integer Replacement</a>
 * User: liyulin
 * Date: 2019/11/13
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        return replaceHelper(n, map);
    }

    public int replaceHelper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res;
        if (n % 2 == 0) {
            res = replaceHelper(n / 2, map) + 1;
        } else {
            // fix stack overflow with 1 + (n - 1) / 2 OR (n - 1) / 2
            res = Math.min(replaceHelper(1 + (n - 1) / 2, map), replaceHelper((n - 1) / 2, map)) + 2;
        }
        map.put(n, res);
        return res;
    }
}
