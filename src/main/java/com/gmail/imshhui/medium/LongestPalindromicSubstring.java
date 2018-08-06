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

    /**
     * version accepted by LeetCode
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        s = initString(s);
        char[] chars = s.toCharArray();
        int length = chars.length;
        int longest = 0;
        String result = "";
        for (int i = 0; i < length; i++) {
            int j = i - 1, k = i + 1;
            int temp = 0;
            while (j >= 0 && k <= length - 1) {
                if (chars[j] == chars[k]) {
                    temp++;
                    j--;
                    k++;
                } else {
                    break;
                }
            }
            if (longest < temp) {
                longest = temp;
                result = s.substring(++j, k);
            }
        }
        return result.replace("#", "");
    }

    private String initString(String s) {
        String split = "#";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(split).append(chars[i]);
        }
        sb.append(split);
        return sb.toString();
    }
}
