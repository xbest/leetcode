package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/23
 */
public class CompareVersionNumbersTest {
    CompareVersionNumbers client = new CompareVersionNumbers();

    @Test
    public void compareVersion() {
//        Assert.assertEquals(-1, client.compareVersion("0.1", "1.1"));
        Assert.assertEquals(-1, client.compareVersion("1", "1.1"));
    }
}
