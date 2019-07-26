package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/26
 */
public class PlusOneTest {
    PlusOne client = new PlusOne();

    @Test
    public void plusOne() {
        int[] digits = {9};
        int[] expected = {1, 0};
        Assert.assertArrayEquals(expected, client.plusOne(digits));
    }

}
