package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/18
 */
public class CountAndSayTest {
    CountAndSay client = new CountAndSay();

    @Test
    public void countAndSay() {
        Assert.assertEquals("1211", client.countAndSay(4));
    }
}
