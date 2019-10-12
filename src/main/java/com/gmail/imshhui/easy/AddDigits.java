package com.gmail.imshhui.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * @see <a href="https://leetcode.com/problems/add-digits/">258. Add Digits</a>
 * User: liyulin
 * Date: 2019/10/12
 */
public class AddDigits {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
