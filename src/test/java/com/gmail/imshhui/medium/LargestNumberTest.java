package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/24
 */
public class LargestNumberTest {
    LargestNumber client = new LargestNumber();

    @Test
    public void largetstNumber() {
//        Assert.assertEquals("9534330", client.largestNumber(new int[]{3, 30, 34, 5, 9}));
        Assert.assertEquals("210", client.largestNumber(new int[]{10, 2}));
    }
}
