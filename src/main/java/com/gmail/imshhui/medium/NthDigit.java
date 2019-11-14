package com.gmail.imshhui.medium;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 * @see <a href="https://leetcode.com/problems/nth-digit/">400. Nth Digit</a>
 * User: liyulin
 * Date: 2019/11/14
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int start = 1;
        int length = 1;
        long base = 9;
        while (n > length * base) {
            n = n - length * (int) base;
            length++;
            base = base * 10;
            start = start * 10;
        }
        int target = start+(n-1)/length;
        int reminder = (n-1)%length;
        return Character.getNumericValue(String.valueOf(target).charAt(reminder));
    }
}
