package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2020/1/13
 */
public class A132PatternTest {
    A132Pattern client = new A132Pattern();

    @Test
    public void find132pattern() {
        Assert.assertEquals(false, client.find132pattern(new int[]{1, 0, 1, -4, -3}));
    }
}
