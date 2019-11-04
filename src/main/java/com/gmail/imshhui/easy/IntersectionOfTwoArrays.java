package com.gmail.imshhui.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays/"></a>
 * User: liyulin
 * Date: 2019/11/4
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }
        for (int i : nums2) {
            if (num1Set.size() > 0 && num1Set.contains(i)) {
                res.add(i);
            }
        }
        int[] intersection = new int[res.size()];
        Iterator<Integer> iterator = res.iterator();
        for (int i = 0; i < intersection.length; i++) {
            intersection[i] = iterator.next();
        }
        return intersection;
    }
}
