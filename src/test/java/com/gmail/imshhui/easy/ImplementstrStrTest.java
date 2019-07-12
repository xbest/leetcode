package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/12
 */
public class ImplementstrStrTest {
    private ImplementstrStr client = new ImplementstrStr();

    @Test
    public void strStrTest() {
        Assert.assertEquals(0, client.strStr1("", ""));
        Assert.assertEquals(-1, client.strStr1("aaa", "aaaa"));
        Assert.assertEquals(4, client.strStr1("mississippi", "issip"));
    }
}
