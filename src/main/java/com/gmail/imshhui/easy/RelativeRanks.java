package com.gmail.imshhui.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores,
 * so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 *
 * @see <a href="https://leetcode.com/problems/relative-ranks/">506. Relative Ranks</a>
 * User: liyulin
 * Date: 2020/2/18
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> scoreIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            scoreIndex.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] res = new String[nums.length];
        for (int i = nums.length - 1, ranks = 1; i >= 0; i--, ranks++) {
            res[scoreIndex.get(nums[i])] = ranks + "";
            if (ranks == 1) {
                res[scoreIndex.get(nums[i])] = "Gold Medal";
            }
            if (ranks == 2) {
                res[scoreIndex.get(nums[i])] = "Silver Medal";
            }
            if (ranks == 3) {
                res[scoreIndex.get(nums[i])] = "Bronze Medal";
            }

        }
        return res;
    }
}
