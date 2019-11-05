package com.gmail.imshhui.easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 *
 * @see <a href="https://leetcode.com/problems/valid-perfect-square/">367. Valid Perfect Square</a>
 * User: liyulin
 * Date: 2019/11/5
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num = num - i;
            i = i + 2;
        }
        return num == 0;
    }
}
