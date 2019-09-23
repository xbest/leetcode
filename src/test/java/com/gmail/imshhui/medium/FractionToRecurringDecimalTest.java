package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/23
 */
public class FractionToRecurringDecimalTest {
    FractionToRecurringDecimal client = new FractionToRecurringDecimal();

    @Test
    public void fractionToDecimal() {
//        Assert.assertEquals("0.(6)", client.fractionToDecimal(2, 3));
        Assert.assertEquals("0.(012)", client.fractionToDecimal(4, 333));
    }
}
