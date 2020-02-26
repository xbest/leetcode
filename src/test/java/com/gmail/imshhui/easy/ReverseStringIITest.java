package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2020/2/26
 */
public class ReverseStringIITest {
    ReverseStringII client = new ReverseStringII();

    @Test
    public void reverseStr() {
        Assert.assertEquals("bacdfeg", client.reverseStr("abcdefg", 2));
    }
}
