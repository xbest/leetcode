package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/11/4
 */
public class ReverseVowelsOfAStringTest {
    ReverseVowelsOfAString client = new ReverseVowelsOfAString();

    @Test
    public void reverseVowelsTest() {
        Assert.assertEquals("holle", client.reverseVowels("hello"));
    }
}
