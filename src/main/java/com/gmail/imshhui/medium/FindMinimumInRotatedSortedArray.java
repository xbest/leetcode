package com.gmail.imshhui.medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/"></a>
 * User: liyulin
 * Date: 2019/9/18
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums == null || nums.length == 0 ? 0 : nums[0];
    }
}
