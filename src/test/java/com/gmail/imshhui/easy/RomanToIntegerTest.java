package com.gmail.imshhui.easy;

import com.gmail.imshhui.medium.IntegerToRoman;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/9/26
 */
public class RomanToIntegerTest {
    private RomanToInteger client = new RomanToInteger();

    @Test
    public void romanToIntTest() {
        Assert.assertEquals(3, client.romanToInt("III"));
        Assert.assertEquals(4, client.romanToInt("IV"));
        Assert.assertEquals(9, client.romanToInt("IX"));
        Assert.assertEquals(58, client.romanToInt("LVIII"));
        Assert.assertEquals(1994, client.romanToInt("MCMXCIV"));
        Assert.assertEquals(3000, client.romanToInt("MMM"));
    }
}
