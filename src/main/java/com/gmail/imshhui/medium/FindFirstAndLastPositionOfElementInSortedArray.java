package com.gmail.imshhui.medium;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"></a>
 * User: liyulin
 * Date: 2019/7/17
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] position = {-1, -1};
        position[0] = binarySearch(nums, target, true);
        position[1] = binarySearch(nums, target, false);
        return position;
    }

    private int binarySearch(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                if (left) {
                    if (mid - 1 < 0 || mid - 1 >= 0 && target > nums[mid - 1]) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (mid + 1 > nums.length - 1 || mid + 1 <= nums.length - 1 && target < nums[mid + 1]) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
