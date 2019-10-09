package com.gmail.imshhui.medium;

import org.junit.Test;

import java.util.List;

/**
 * User: liyulin
 * Date: 2019/10/9
 */
public class CombinationSumIIITest {
    CombinationSumIII client = new CombinationSumIII();

    @Test
    public void combinationSum3() {
        List<List<Integer>> list = client.combinationSum3(3, 7);
        System.out.println(list);
    }
}
