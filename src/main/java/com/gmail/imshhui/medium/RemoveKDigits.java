package com.gmail.imshhui.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 * @see <a href="https://leetcode.com/problems/remove-k-digits/">402. Remove K Digits</a>
 * User: liyulin
 * Date: 2019/11/14
 */
public class RemoveKDigits {
    private int min = Integer.MAX_VALUE;

    public String removeKdigits(String num, int k) {
        // corner case
        if (num.length() == k) {
            return "0";
        }
        removeHelper(num, k, 0, new HashSet<>());
        return Integer.toString(min);
    }

    private void removeHelper(String num, int k, int pos, Set<Integer> idxs) {
        if (k == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num.length(); i++) {
                if (idxs.contains(i)) {
                    continue;
                }
                sb.append(num.charAt(i));
            }
            min = Math.min(min, Integer.valueOf(sb.toString()));
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            idxs.add(i);
            removeHelper(num, k - 1, i + 1, idxs);
            idxs.remove(i);
        }
    }
}
