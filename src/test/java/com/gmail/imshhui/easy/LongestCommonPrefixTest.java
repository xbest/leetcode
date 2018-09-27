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

    @Test
    public void longestCommonPrefix1Test() {
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", client.longestCommonPrefix1(strs));
        String[] strs1 = {"dog","racecar","car"};
        Assert.assertEquals("", client.longestCommonPrefix1(strs1));
        String[] strs2 = {"dog"};
        Assert.assertEquals("dog", client.longestCommonPrefix1(strs2));
        String[] strs3 = null;
        Assert.assertEquals("", client.longestCommonPrefix1(strs3));
        String[] strs4 = {""};
        Assert.assertEquals("", client.longestCommonPrefix1(strs4));
    }

    @Test
    public void longestCommonPrefix2Test() {
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", client.longestCommonPrefix2(strs));
        String[] strs1 = {"dog","racecar","car"};
        Assert.assertEquals("", client.longestCommonPrefix2(strs1));
        String[] strs2 = {"dog"};
        Assert.assertEquals("dog", client.longestCommonPrefix2(strs2));
        String[] strs3 = null;
        Assert.assertEquals("", client.longestCommonPrefix2(strs3));
        String[] strs4 = {""};
        Assert.assertEquals("", client.longestCommonPrefix2(strs4));
        String[] strs5 = {"aa","a"};
        Assert.assertEquals("a", client.longestCommonPrefix2(strs5));
    }

    @Test
    public void longestCommonPrefix3Test() {
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", client.longestCommonPrefix3(strs));
        String[] strs1 = {"dog","racecar","car"};
        Assert.assertEquals("", client.longestCommonPrefix3(strs1));
        String[] strs2 = {"dog"};
        Assert.assertEquals("dog", client.longestCommonPrefix3(strs2));
        String[] strs3 = null;
        Assert.assertEquals("", client.longestCommonPrefix3(strs3));
        String[] strs4 = {""};
        Assert.assertEquals("", client.longestCommonPrefix3(strs4));
        String[] strs5 = {"aa","a"};
        Assert.assertEquals("a", client.longestCommonPrefix3(strs5));
    }
}
