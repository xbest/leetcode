package com.gmail.imshhui.easy;

import java.util.jar.JarEntry;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome/"></a>
 * User: liyulin
 * Date: 2019/8/29
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            if (!isAlphaNumeric(chars[i])) {
                i++;
            }
            if (!isAlphaNumeric(chars[j])) {
                j--;
            }
            // avoid the out of bound exception
            if (i < chars.length && j >= 0 && isAlphaNumeric(chars[i]) && isAlphaNumeric(chars[j])) {
                if (chars[i] != chars[j]) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z';
    }
}
