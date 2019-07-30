package com.gmail.imshhui.medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/"></a>
 * User: liyulin
 * Date: 2019/7/30
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            while (start < end && nums[start] == nums[end]) {
                // fix the bad case: nums=[1,3,1,1,1], target=3
                start++;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
