package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 * @see <a href="https://leetcode.com/problems/summary-ranges/"></a>
 * User: liyulin
 * Date: 2019/10/10
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        StringBuilder range = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            if (Math.abs(nums[i + 1] - nums[i]) == 1) {
                if (range.toString().isEmpty()) {
                    range.append(nums[i]).append("->").append(nums[i + 1]);
                } else {
                    range.replace(range.lastIndexOf(">") + 1, range.length(), String.valueOf(nums[i + 1]));
                }
                if (i == nums.length - 2) {
                    // the last set of elements
                    res.add(range.toString());
                }
            } else {
                if (range.toString().isEmpty()) {
                    range.append(nums[i]);
                }
                res.add(range.toString());
                range = new StringBuilder();
                if (i == nums.length - 2) {
                    // the last element
                    res.add(String.valueOf(nums[i + 1]));
                }
            }
        }
        return res;
    }
}
