package com.gmail.imshhui.easy;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 *
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/"></a>
 * User: liyulin
 * Date: 2019/8/5
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; j < n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1, 0, m + n);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {
            nums1[i] = nums1[j];
        }
        int i = 0, j = 0, k = n;
        for (; i < m + n && k < m + n && j < n; i++) {
            if (nums1[k] > nums2[j]) {
                nums1[i] = nums2[j++];
            } else {
                nums1[i] = nums1[k++];
            }
        }
        while (k < m + n) {
            nums1[i++] = nums1[k++];
        }
        while (j < n) {
            nums1[i++] = nums2[j++];
        }
    }
}
