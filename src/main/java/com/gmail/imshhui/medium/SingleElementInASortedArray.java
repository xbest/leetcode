package com.gmail.imshhui.medium;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">540. Single Element in a Sorted Array</a>
 * User: liyulin
 * Date: 2020/2/26
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNonDuplicatelogN(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 2;
            }
        }
        return nums[low];
    }
}
