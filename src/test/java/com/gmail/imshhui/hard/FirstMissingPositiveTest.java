package com.gmail.imshhui.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/19
 */
public class FirstMissingPositiveTest {
    FirstMissingPositive client = new FirstMissingPositive();

    @Test
    public void firstMissingPositive() {
        int[] nums = {2, 1};
        Assert.assertEquals(3, client.firstMissingPositive(nums));

        int[] nums1 = {1, 2, 0};
        Assert.assertEquals(3, client.firstMissingPositive(nums1));

        int[] nums2 = {4, 1, 2, 3};
        Assert.assertEquals(5, client.firstMissingPositive(nums2));
    }
}
