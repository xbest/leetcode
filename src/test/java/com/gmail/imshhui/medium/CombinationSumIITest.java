package com.gmail.imshhui.medium;

import org.junit.Test;

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
public class CombinationSumIITest {

    CombinationSumII client = new CombinationSumII();

    @Test
    public void combinationSum2Test() {
        int[][] expecteds = {{1, 1, 6}, {1, 2, 5}, {1, 7}, {2, 6}};
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ret = client.combinationSum2(candidates, target);
        System.out.println(ret);
    }
}
