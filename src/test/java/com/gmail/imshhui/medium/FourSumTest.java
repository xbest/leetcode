package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: liyulin
 * Date: 2018/9/27
 */
public class FourSumTest {
    private FourSum client = new FourSum();

    @Test
    public void fourSumTest() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(-2);
        tempList.add(0);
        tempList.add(0);
        tempList.add(2);
        list.add(tempList);
        tempList = new ArrayList<>();
        tempList.add(-2);
        tempList.add(-1);
        tempList.add(1);
        tempList.add(2);
        list.add(tempList);
        tempList = new ArrayList<>();
        tempList.add(-1);
        tempList.add(0);
        tempList.add(0);
        tempList.add(1);
        list.add(tempList);
        Assert.assertEquals(list, client.fourSum(nums, target));
    }

    @Test
    public void fourSumTest1() {
        // 此情况下，在LeetCode运行超时，显示运行34ms
        int[] nums = {-497, -473, -465, -462, -450, -445, -411, -398, -398, -392, -382, -376, -361, -359,
                -353, -347, -329, -328, -317, -307, -273, -230, -228, -227, -217, -199, -190, -175, -155,
                -151, -122, -102, -97, -96, -95, -87, -85, -84, -73, -71, -51, -50, -39, -24, -19, -1, -1,
                7, 22, 25, 27, 37, 40, 43, 45, 51, 72, 91, 97, 108, 119, 121, 122, 123, 127, 156, 166, 171,
                175, 180, 203, 211, 217, 218, 224, 231, 245, 293, 297, 299, 300, 318, 326, 336, 353, 358, 376,
                391, 405, 423, 445, 451, 459, 464, 471, 486, 487, 488};
        int target = 2251;
        List<List<Integer>> list = new ArrayList<>();
        Assert.assertEquals(list, client.fourSum(nums, target));
    }
}
