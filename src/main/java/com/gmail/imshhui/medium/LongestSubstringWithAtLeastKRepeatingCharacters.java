package com.gmail.imshhui.medium;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/">395. Longest Substring with At Least K Repeating Characters</a>
 * User: liyulin
 * Date: 2019/11/8
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return kHelper(s, k, 0, s.length() - 1);
    }

    private int kHelper(String s, int k, int left, int right) {
        if (left > right) {
            return 0;
        }
        int[] chars = new int[26];
        for (int i = left; i <= right; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        int result = Integer.MIN_VALUE;
        while (left < right && chars[s.charAt(left) - 'a'] < k) {
            left++;
        }
        while (left < right && chars[s.charAt(right) - 'a'] < k) {
            right--;
        }
        for (int i = left; i <= right; i++) {
            if (chars[s.charAt(i) - 'a'] < k) {
                result = Math.max(kHelper(s, k, left, i - 1), kHelper(s, k, i + 1, right));
            }
        }
        if (result == Integer.MIN_VALUE) {
            result = right - left + 1;
        }
        return result;
    }
}
