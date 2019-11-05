package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 * @see <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">373. Find K Pairs with Smallest Sums</a>
 * User: liyulin
 * Date: 2019/11/5
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[i]);
            temp.add(nums2[0]);
            temp.add(0);
            queue.offer(temp);
        }
        while (k > 0 && !queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            int nums2Index = temp.remove(2);
            res.add(temp);
            if (nums2Index >= nums2.length) {
                continue;
            }
            List<Integer> num = new ArrayList<>();
            num.add(temp.get(0));
            num.add(nums2[nums2Index + 1]);
            num.add(nums2Index + 1);
            queue.offer(num);
            k--;
        }
        return res;
    }
}
