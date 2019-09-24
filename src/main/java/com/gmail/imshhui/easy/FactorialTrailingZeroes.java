package com.gmail.imshhui.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @see <a href="https://leetcode.com/problems/factorial-trailing-zeroes/"></a>
 * User: liyulin
 * Date: 2019/9/24
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n = n / 5;
            res = res + n;
        }
        return res;
    }
}
