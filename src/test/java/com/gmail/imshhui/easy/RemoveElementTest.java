package com.gmail.imshhui.easy;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/11
 */
public class RemoveElementTest {
    private RemoveElement client = new RemoveElement();

    @Test
    public void removeElementTest() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int length = client.removeElement(nums, val);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
