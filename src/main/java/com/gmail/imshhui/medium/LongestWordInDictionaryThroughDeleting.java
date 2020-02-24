package com.gmail.imshhui.medium;

import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 *
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 *
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 *
 * @see <a href="https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/">524. Longest Word in Dictionary through Deleting</a>
 * User: liyulin
 * Date: 2020/2/24
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            // If there are more than one possible results, return the longest word with the smallest lexicographical order.
            if (i == dictWord.length() && dictWord.length() >= res.length()) {
                res = dictWord.length() > res.length() || dictWord.compareTo(res) < 0 ? dictWord : res;
            }
        }
        return res;
    }
}
