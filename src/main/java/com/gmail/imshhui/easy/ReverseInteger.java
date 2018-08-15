package com.gmail.imshhui.easy;

/**
 * User: liyulin
 * Date: 2018/8/14
 */
public class ReverseInteger {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) ? 0 : (int) rev;
    }
}
