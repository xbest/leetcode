package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/26
 */
public class AddBinaryTest {
    AddBinary client = new AddBinary();

    @Test
    public void addBinary() {
        String a = "1010";
        String b = "1011";
//        Assert.assertEquals("10101", client.addBinary(a, b));
        Assert.assertEquals("11110", client.addBinary("1111", "1111"));
    }
}
