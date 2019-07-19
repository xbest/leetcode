package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/"></a>
 * User: liyulin
 * Date: 2019/7/19
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(ret, temp, candidates, target, 0);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            ret.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // THINK: Why i>start, not i>0, skip the duplicates but DO NOT skip the duplicate candidates originally in the candidates list.
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                backtrace(ret, temp, candidates, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
