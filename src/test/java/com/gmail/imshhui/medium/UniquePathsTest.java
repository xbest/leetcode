package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/26
 */
public class UniquePathsTest {
    UniquePaths client = new UniquePaths();

    @Test
    public void uniquePaths() {
        Assert.assertEquals(3, client.uniquePaths(3, 2));
        Assert.assertEquals(28, client.uniquePaths(7, 3));
        Assert.assertEquals(70, client.uniquePaths(5, 5));
        Assert.assertEquals(3, client.uniquePaths1(3, 2));
        Assert.assertEquals(28, client.uniquePaths1(7, 3));
        Assert.assertEquals(70, client.uniquePaths1(5, 5));
    }
}
