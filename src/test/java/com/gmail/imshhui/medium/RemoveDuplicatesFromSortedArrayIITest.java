package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/30
 */
public class RemoveDuplicatesFromSortedArrayIITest {
    RemoveDuplicatesFromSortedArrayII client = new RemoveDuplicatesFromSortedArrayII();

    @Test
    public void removeDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assert.assertEquals(7, client.removeDuplicates(nums));
    }
}
