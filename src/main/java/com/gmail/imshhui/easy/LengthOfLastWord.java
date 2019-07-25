package com.gmail.imshhui.easy;

import java.util.Objects;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 *
 * @see <a href="https://leetcode.com/problems/length-of-last-word/"></a>
 * User: liyulin
 * Date: 2019/7/24
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (Objects.isNull(s) || s == "") {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                length++;
            } else {
                if (length != 0) {
                    break;
                }
            }
        }
        return length;
    }
}
