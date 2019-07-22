package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/permutations-ii/"></a>
 * User: liyulin
 * Date: 2019/7/22
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, list, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }

    private void backtrace(int[] nums, List<List<Integer>> list, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrace(nums, list, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
