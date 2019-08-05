package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/30
 */
public class SearchInRotatedSortedArrayIITest {
    SearchInRotatedSortedArrayII client = new SearchInRotatedSortedArrayII();

    @Test
    public void search() {
        int[] nums = {1, 3, 1, 1, 1};
        int target = 3;
        Assert.assertEquals(true, client.search(nums, target));
        int[] nums1 = {1, 1, 1, 3, 1};
        Assert.assertEquals(true, client.search(nums1, target));
    }
}
