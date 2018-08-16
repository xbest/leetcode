package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/8/15
 */
public class StringToIntegerTest {
    private StringToInteger client = new StringToInteger();

    @Test
    public void myAtoiTest() {
        Assert.assertEquals(42, client.myAtoi("42"));
        Assert.assertEquals(-42, client.myAtoi("   -42"));
        Assert.assertEquals(4193, client.myAtoi("4193 with words"));
        Assert.assertEquals(0, client.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, client.myAtoi("-91283472332"));
        Assert.assertEquals(42, client.myAtoi("42"));
        Assert.assertEquals(2147483647, client.myAtoi("20000000000000000000"));
        Assert.assertEquals(0, client.myAtoi("0-1"));
    }
}
