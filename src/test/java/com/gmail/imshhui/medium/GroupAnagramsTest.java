package com.gmail.imshhui.medium;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/23
 */
public class GroupAnagramsTest {
    GroupAnagrams client = new GroupAnagrams();

    @Test
    public void groupAnagrams() {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(client.groupAnagrams(strings));
    }
}
