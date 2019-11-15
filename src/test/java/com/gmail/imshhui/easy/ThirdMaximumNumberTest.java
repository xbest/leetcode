package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/11/15
 */
public class ThirdMaximumNumberTest {
    ThirdMaximumNumber client = new ThirdMaximumNumber();

    @Test
    public void thirdMaxTest() {
        Assert.assertEquals(2, client.thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
    }
}
