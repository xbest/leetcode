package com.gmail.imshhui.easy;

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

    @Test
    public void twoSumOnepassHashmapTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = client.twoSumOnepassHashmap(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    @Test
    public void twoSumTwopassHashmapTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = client.twoSumTwopassHashmap(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
