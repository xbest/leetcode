package com.gmail.imshhui.easy;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 * @see <a href="https://leetcode.com/problems/sum-of-two-integers/">371. Sum of Two Integers</a>
 * User: liyulin
 * Date: 2019/11/5
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
