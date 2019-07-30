package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @see <a href="https://leetcode.com/problems/combinations/"></a>
 * User: liyulin
 * Date: 2019/7/30
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(ret, new ArrayList<>(), 1, n, k);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            ret.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrace(ret, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
