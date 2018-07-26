package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, String> stringMap = new HashMap<>();
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            int tempLength = 0;
            for (int j = i; j < chars.length; j++) {
                if (stringMap.containsKey(chars[j])) {
                    break;
                }
                tempLength++;
                stringMap.put(chars[j], "");
            }
            stringMap.clear();
            length = length > tempLength ? length : tempLength;
        }
        return length;
    }
}
