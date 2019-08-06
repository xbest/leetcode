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
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2 = {3};
        client.merge1(nums1, 5, nums2, 1);
    }
}
