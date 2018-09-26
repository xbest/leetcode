package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/9/25
 */
public class IntegerToRomanTest {
    private IntegerToRoman client = new IntegerToRoman();

    @Test
    public void intToRomanTest() {
        Assert.assertEquals("III", client.intToRoman(3));
        Assert.assertEquals("IV", client.intToRoman(4));
        Assert.assertEquals("IX", client.intToRoman(9));
        Assert.assertEquals("LVIII", client.intToRoman(58));
        Assert.assertEquals("MCMXCIV", client.intToRoman(1994));
        Assert.assertEquals("MMM", client.intToRoman(3000));
    }
}
