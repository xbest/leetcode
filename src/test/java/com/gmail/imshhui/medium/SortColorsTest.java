package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/30
 */
public class SortColorsTest {
    SortColors client = new SortColors();

    @Test
    public void sortColors() {
        int[] expected = {0, 0, 1, 1, 2, 2};
        int[] nums = {2, 0, 2, 1, 1, 0};
        client.sortColors1(nums);
        Assert.assertArrayEquals(expected, nums);
    }
}
