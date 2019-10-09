package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/10/9
 */
public class ContainsDuplicateIIITest {
    ContainsDuplicateIII client = new ContainsDuplicateIII();

    @Test
    public void containsNearbyAlmostDuplicate() {
//        Assert.assertEquals(false, client.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
        Assert.assertEquals(false, client.containsNearbyAlmostDuplicate(new int[]{-2147483647, 2147483647}, 1,
                2147483647));
    }
}
