package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/16
 */
public class GasStationTest {
    GasStation client = new GasStation();

    @Test
    public void gasStationTest() {
        int[] gas = {3, 3, 4};
        int[] cost = {3, 4, 4};
        Assert.assertEquals(-1, client.canCompleteCircuit(gas, cost));
    }
}
