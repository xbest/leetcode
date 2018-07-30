package com.gmail.imshhui.medium;

/**
 * User: liyulin
 * Date: 2018/7/30
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        int longest = 0;
        String result = "";
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && longest < sub.length()) {
                    result = sub;
                    longest = sub.length();
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
