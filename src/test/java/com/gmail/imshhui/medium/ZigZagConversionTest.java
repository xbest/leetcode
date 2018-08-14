package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/8/7
 */
public class ZigZagConversionTest {
    private ZigZagConversion client = new ZigZagConversion();

    @Test
    public void convertTest() {
        Assert.assertEquals("PAHNAPLSIIGYIR", client.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("AB", client.convert("AB", 1));
        Assert.assertEquals("ACB", client.convert("ABC", 2));
    }
}
