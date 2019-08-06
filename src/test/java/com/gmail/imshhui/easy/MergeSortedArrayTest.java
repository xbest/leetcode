package com.gmail.imshhui.easy;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/8/5
 */
public class MergeSortedArrayTest {
    MergeSortedArray client = new MergeSortedArray();

    @Test
    public void mergeSortedArray() {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        client.merge(nums1, 1, nums2, 1);
    }
}
