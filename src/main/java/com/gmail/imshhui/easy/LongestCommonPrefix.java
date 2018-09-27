package com.gmail.imshhui.easy;

import java.util.Objects;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 * <p>
 * User: liyulin
 * Date: 2018/9/26
 */
public class LongestCommonPrefix {
    /**
     * brute force
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = strs[0].toCharArray();
        boolean isContinue = true;
        for (int i = 0; i < chars.length && isContinue; i++) {
            for (int j = 1; j < strs.length; j++) {
                char[] otherChars = strs[j].toCharArray();
                if (i < otherChars.length && otherChars[i] == chars[i]) {
                    if (j == strs.length - 1) {
                        sb.append(chars[i]);
                    }
                } else {
                    isContinue = false;
                    break;
                }
            }
        }
        return sb.toString();
    }

    /**
     * horizontal scanning
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /**
     * vertical scanning
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * divide and conquer
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String leftStr = longestCommonPrefix(strs, left, mid);
            String rightStr = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(leftStr, rightStr);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
