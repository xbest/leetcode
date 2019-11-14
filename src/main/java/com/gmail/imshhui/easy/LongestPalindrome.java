package com.gmail.imshhui.easy;

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * @see <a href="https://leetcode.com/problems/longest-palindrome/">409. Longest Palindrome</a>
 * User: liyulin
 * Date: 2019/11/14
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 != 0) {
                odd++;
            }
        }
        return odd == 0 ? s.length() : s.length() - odd + 1;
    }
}
