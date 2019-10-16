package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/10/16
 */
public class LongestIncreasingSubsequenceTest {
    LongestIncreasingSubsequence client = new LongestIncreasingSubsequence();

    @Test
    public void lengthOfLIS() {
        Assert.assertEquals(4, client.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
