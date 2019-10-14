package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/10/14
 */
public class UglyNumberTest {
    UglyNumber client = new UglyNumber();
    @Test
    public void uglyNumber() {
//        Assert.assertEquals(true,client.isUgly(14));
        Assert.assertEquals(true,client.isUgly(20));
    }
}
