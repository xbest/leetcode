package com.gmail.imshhui.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 * @see <a href="https://leetcode.com/problems/repeated-substring-pattern/">459. Repeated Substring Pattern</a>
 * User: liyulin
 * Date: 2020/1/16
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            String sub = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length() / i; j++) {
                sb.append(sub);
            }
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}
