package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * @see <a href="https://leetcode.com/problems/contains-duplicate-iii/"></a>
 * User: liyulin
 * Date: 2019/10/9
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                // bad case: the max integer
                // [-1,2147483647], 1, 2147483647
                // [-214748364`7,2147483647], 1, 2147483647
                long temp = (long) nums[j] - (long) nums[j + i];
                if (Math.abs(temp) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> bucket = new HashMap<>();
        long width = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long id = bucketId(num, width);
            if (bucket.containsKey(id)) {
                return true;
            }
            if (bucket.containsKey(id + 1) && Math.abs(bucket.get(id + 1) - num) < width
                    || bucket.containsKey(id - 1) && Math.abs(bucket.get(id - 1) - num) < width) {
                return true;
            }
            bucket.put(id, num);
            if (i >= k) {
                bucket.remove(bucketId(nums[i - k], width));
            }
        }

        return false;
    }

    private long bucketId(long x, long w) {
        return x < 0 ? x + 1 / w - 1 : x / w;
    }
}
