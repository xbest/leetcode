package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: liyulin
 * Date: 2018/9/27
 */
public class ThreeSumTest {
    private ThreeSum client = new ThreeSum();

    @Test
    public void threeSumTest() {
        int[] nums = {-1,-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(-1);
        tempList.add(-1);
        tempList.add(2);
        list.add(tempList);
        tempList = new ArrayList<>();
        tempList.add(-1);
        tempList.add(0);
        tempList.add(1);
        list.add(tempList);
        Assert.assertEquals(list, client.threeSum(nums));
    }
}
