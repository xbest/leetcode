package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/23
 */
public class MaximumSubarrayTest {
    MaximumSubarray client = new MaximumSubarray();

    @Test
    public void maximumSubarray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assert.assertEquals(6, client.maxSubArray(nums));
    }
}
