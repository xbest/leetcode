package com.gmail.imshhui.easy;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * @see <a href="https://leetcode.com/problems/implement-strstr/"></a>
 * User: liyulin
 * Date: 2019/7/12
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        // LeetCode does not support needle == "" actually
        if (needle.isEmpty()) {
            return 0;
        }
        int index = -1, i, j;
        for (i = 0; i < haystack.length(); i++) {
            // use temp to cache the i index, change the temp to iterate the whole needle
            // make sure temp is outside the second for iterator
            int temp = i;
            for (j = 0; j < needle.length() && temp < haystack.length(); ) {
                if (haystack.charAt(temp) == needle.charAt(j)) {
                    // if j iterator the whole needle, then matched
                    if (j == needle.length() - 1) {
                        index = temp - needle.length() + 1;
                    }
                    j++;
                    temp++;
                } else {
                    break;
                }
            }
            if (index != -1) {
                // if index does not equal -1, break the first iterator since the needle matched in the haystack
                break;
            }
        }
        return index;
    }

    public int strStr1(String haystack, String needle) {
        // LeetCode does not support needle == "" actually
        if (needle.isEmpty()) {
            return 0;
        }
        // make sure that haystack.length() - needle.length() PLUS ONE to avoid case miss one element, such as case: "a", "a"
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            // use i + j instead of temp
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++) {
                // if j iterator the whole needle, then matched
                if (j == needle.length() - 1) {
                    return i;
                }
            }

        }
        return -1;
    }
}
