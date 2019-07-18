package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/18
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {
    private FindFirstAndLastPositionOfElementInSortedArray client = new FindFirstAndLastPositionOfElementInSortedArray();

    @Test
    public void searchRangeTest() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = client.searchRange(nums, target);
        int[] expect = {3, 4};
        Assert.assertArrayEquals(expect, result);
    }
}
