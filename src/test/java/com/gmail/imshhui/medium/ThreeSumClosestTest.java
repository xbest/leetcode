package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/12/17
 */
public class ThreeSumClosestTest {
    private ThreeSumClosest client = new ThreeSumClosest();

    @Test
    public void threeSumClosestTest() {
        int[] nums = {1, 1, 1, 1};
        int target = 0;
        Assert.assertEquals(3, client.threeSumClosest(nums, target));
        int[] nums1 = {0, 2, 1, -3};
        int target1 = 1;
        Assert.assertEquals(0, client.threeSumClosest(nums1, target1));
    }
}
