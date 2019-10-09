package com.gmail.imshhui.medium;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/"></a>
 * User: liyulin
 * Date: 2019/10/8
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        k = nums.length - k;
        while (true) {
            int i = partition(nums, low, high);
            if (i < k) {
                low = i + 1;
            } else if (i > k) {
                high = i - 1;
            } else {
                return nums[i];
            }
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
