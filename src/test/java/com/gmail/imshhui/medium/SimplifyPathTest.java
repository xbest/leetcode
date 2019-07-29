package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/29
 */
public class SimplifyPathTest {
    SimplifyPath client = new SimplifyPath();

    @Test
    public void simplifyPath() {
        Assert.assertEquals("/a/b/c", client.simplifyPath("/a//b////c/d//././/.."));
        Assert.assertEquals("/", client.simplifyPath("/../"));
    }
}
