package com.gmail.imshhui.medium;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 *
 * @see <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/"></a>
 * User: liyulin
 * Date: 2019/9/25
 */
public class BitwiseANDofNumbersRange {
    // if m!=n, [m,n]区间内必然含有偶数，那么按位与后必然是0
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }
}
