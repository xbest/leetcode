package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/9/26
 */
public class LongestCommonPrefixTest {
    private LongestCommonPrefix client = new LongestCommonPrefix();

    @Test
    public void longestCommonPrefixTest() {
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", client.longestCommonPrefix(strs));
        String[] strs1 = {"dog","racecar","car"};
        Assert.assertEquals("", client.longestCommonPrefix(strs1));
        String[] strs2 = {"dog"};
        Assert.assertEquals("dog", client.longestCommonPrefix(strs2));
        String[] strs3 = null;
        Assert.assertEquals("", client.longestCommonPrefix(strs3));
        String[] strs4 = {""};
        Assert.assertEquals("", client.longestCommonPrefix(strs4));
    }
}
