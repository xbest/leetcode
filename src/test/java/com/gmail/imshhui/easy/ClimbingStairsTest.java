package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/29
 */
public class ClimbingStairsTest {
    ClimbingStairs client = new ClimbingStairs();

    @Test
    public void climbStairs() {
        Assert.assertEquals(2, client.climbStairs(2));
        Assert.assertEquals(3, client.climbStairs(3));
    }
}
