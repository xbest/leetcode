package com.gmail.imshhui.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 此处2都是上角标，是2次方
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @see <a href="https://leetcode.com/problems/happy-number/"></a>
 * User: liyulin
 * Date: 2019/9/26
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (!set.add(n)) {
                break;
            }
            n = digitsSquare(n);
        }
        return n == 1;
    }

    private int digitsSquare(int n) {
        int sum = 0;
//        String s = String.valueOf(n);
//        for (int i = 0; i < s.length(); i++) {
//            int x = s.charAt(i) - 48;
//            sum = sum + x * x;
//        }
        while (n > 0) {
            int remainder;
            // 可以用位运算&代替取模%，a%b=a&(b-1)，如果b是2^n，b是2的N次方，此处不行
            remainder = n % 10;
            sum = sum + remainder * remainder;
            n = n / 10;
        }
        return sum;
    }
}
