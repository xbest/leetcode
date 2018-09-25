package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/9/25
 */
public class ContainerWithMostWaterTest {
    private ContainerWithMostWater client = new ContainerWithMostWater();

    @Test
    public void maxAreaTest() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49, client.maxArea(height));
        Assert.assertEquals(49, client.maxArea2(height));
    }
}
