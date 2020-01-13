package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2020/1/13
 */
public class AssignCookiesTEst {
    AssignCookies client = new AssignCookies();

    @Test
    public void findContentChildren() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Assert.assertEquals(1, client.findContentChildren(g, s));
        Assert.assertEquals(2, client.findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }

}
