package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/8/14
 */
public class ReverseIntegerTest {
    private ReverseInteger client = new ReverseInteger();

    @Test
    public void reverseTest() {
        System.out.println(123%10);
        Assert.assertEquals(1, client.reverse(10));
        Assert.assertEquals(-1, client.reverse(-10));
        Assert.assertEquals(-1203, client.reverse(-3021));
        Assert.assertEquals(0, client.reverse(0));
        Assert.assertEquals(0, client.reverse(1534236469));
    }
}
