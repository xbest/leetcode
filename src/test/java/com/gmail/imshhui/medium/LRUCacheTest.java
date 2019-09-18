package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/17
 */
public class LRUCacheTest {
    LRUCache client = new LRUCache(2);

    @Test
    public void LRUCacheTest() {
        // the first set of test cases
        Assert.assertEquals(-1, client.get(2));
        client.put(2, 6);
        Assert.assertEquals(-1, client.get(1));
        client.put(1, 5);
        client.put(1, 2);
        Assert.assertEquals(2, client.get(1));
        Assert.assertEquals(6, client.get(2));

        // the second set of test cases
        client.put(2, 1);
        client.put(1, 1);
        client.put(2, 3);
        client.put(4, 1);
        Assert.assertEquals(-1, client.get(1));
        Assert.assertEquals(3, client.get(2));
    }
}
