package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/8/16
 */
public class PalindromeNumberTest {
    private PalindromeNumber client = new PalindromeNumber();

    @Test
    public void isPalindromeTest() {
        Assert.assertEquals(true, client.isPalindrome(121));
        Assert.assertEquals(false, client.isPalindrome(-121));
        Assert.assertEquals(false, client.isPalindrome(10));
        Assert.assertEquals(true, client.isPalindrome(1221));
        Assert.assertEquals(true, client.isPalindrome(12321));
        Assert.assertEquals(false, client.isPalindrome(1232221));
    }
}
