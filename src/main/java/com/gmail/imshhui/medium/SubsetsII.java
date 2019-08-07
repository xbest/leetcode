package com.gmail.imshhui.medium;

import java.util.*;

/**
 * User: liyulin
 * Date: 2019/8/7
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrace(ret, new ArrayList<>(), nums, 0, i);
        }
        return new ArrayList<>(ret);
    }

    private void backtrace(Set<List<Integer>> ret, List<Integer> subset, int[] nums, int start, int k) {
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
