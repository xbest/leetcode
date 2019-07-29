package com.gmail.imshhui.easy;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 * @see <a href="https://leetcode.com/problems/sqrtx/"></a>
 * User: liyulin
 * Date: 2019/7/29
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long r = x;
        while (r > x / r) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
