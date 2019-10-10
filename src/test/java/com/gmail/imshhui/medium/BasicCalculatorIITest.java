package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/10/10
 */
public class BasicCalculatorIITest {
    BasicCalculatorII client = new BasicCalculatorII();

    @Test
    public void calculate() {
        Assert.assertEquals(7, client.calculate("3+2*2"));
        Assert.assertEquals(5, client.calculate(" 3+5 / 2 "));
        Assert.assertEquals(42, client.calculate(" 42 "));
    }
}
