package com.gmail.imshhui;

import com.gmail.imshhui.easy.TwoSum;
import org.junit.Test;

public class TwoSumTest {
    private TwoSum client = new TwoSum();

    @Test
    public void twoSumTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] result = client.twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
