package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @see <a href="https://leetcode.com/problems/subsets/"></a>
 * User: liyulin
 * Date: 2019/7/30
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrace(ret, new ArrayList<>(), nums, 0, i);
        }
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> subset, int[] nums, int start, int k) {
        if (k == 0) {
            ret.add(new ArrayList<>(subset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrace(ret, subset, nums, i + 1, k - 1);
            subset.remove(subset.size() - 1);
        }
    }
}
