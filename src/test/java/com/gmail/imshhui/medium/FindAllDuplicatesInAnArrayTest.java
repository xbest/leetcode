package com.gmail.imshhui.medium;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/11/29
 */
public class FindAllDuplicatesInAnArrayTest {
    FindAllDuplicatesInAnArray client = new FindAllDuplicatesInAnArray();
    @Test
    public void findDuplicatesTest() {
        client.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
