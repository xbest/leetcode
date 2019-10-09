package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @see <a href="https://leetcode.com/problems/combination-sum-iii/"></a>
 * User: liyulin
 * Date: 2019/10/9
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> list, int pos, int k, int n) {
        if (n == 0 || k == 0) {
            if (n == 0 && k == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = pos; i <= 9; i++) {
            list.add(i);
            backtrace(res, list, i + 1, k - 1, n - i);
            list.remove(list.size() - 1);
        }
    }
}
