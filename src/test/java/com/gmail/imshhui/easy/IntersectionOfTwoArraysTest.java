package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/11/4
 */
public class IntersectionOfTwoArraysTest {
    IntersectionOfTwoArrays client = new IntersectionOfTwoArrays();

    @Test
    public void intersection() {
//        Assert.assertEquals(new int[]{2}, client.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assert.assertEquals(new int[]{}, client.intersection(new int[]{}, new int[]{1, 1}));
    }
}
