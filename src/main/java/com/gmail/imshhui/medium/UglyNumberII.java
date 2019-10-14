package com.gmail.imshhui.medium;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 * @see <a href="https://leetcode.com/problems/ugly-number-ii/">264. Ugly Number II</a>
 * User: liyulin
 * Date: 2019/10/14
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            uglyNums[i] = min;
            if (factor2 == min) {
                factor2 = 2 * uglyNums[++index2];
            }
            if (factor3 == min) {
                factor3 = 3 * uglyNums[++index3];
            }
            if (factor5 == min) {
                factor5 = 5 * uglyNums[++index5];
            }
        }
        return uglyNums[n - 1];
    }
}
