package com.gmail.imshhui.medium;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/22
 */
public class PermutationsIITest {
    PermutationsII client = new PermutationsII();
    @Test
    public void permuteUnique() {
        int[] nums = {1, 1, 2};
        System.out.println(client.permuteUnique(nums));
    }
}
