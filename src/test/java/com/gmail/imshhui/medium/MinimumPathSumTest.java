package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/26
 */
public class MinimumPathSumTest {
    MinimumPathSum client = new MinimumPathSum();

    @Test
    public void minPathSum() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Assert.assertEquals(7, client.minPathSum(grid));
    }
}
