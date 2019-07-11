package com.gmail.imshhui.easy;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/11
 */
public class RemoveDuplicatesfromSortedArrayTest {
    private RemoveDuplicatesfromSortedArray client = new RemoveDuplicatesfromSortedArray();

    @Test
    public void removeDuplicatesTest() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length =client.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
