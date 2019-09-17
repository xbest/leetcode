package com.gmail.imshhui.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 * @see <a href="https://leetcode.com/problems/word-break-ii/"></a>
 * User: liyulin
 * Date: 2019/9/16
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrace(s, wordDict, 0, "", new HashMap<>());
    }

    private List<String> backtrace(String s, List<String> wordDict, int pos,
                                   String temp, Map<Integer, List<String>> map) {
        if (map.containsKey(pos)) {
            return map.get(pos);
        }
        List<String> res = new ArrayList<>();
        if (pos == s.length()) {
            res.add("");
            return res;
        }
        for (int i = pos; i < s.length(); i++) {
            String word = s.substring(pos, i + 1);
            if (wordDict.contains(word)) {
                List<String> subList = backtrace(s, wordDict, i + 1, temp + " " + word, map);
                subList.forEach(sub -> res.add(word + (sub.isEmpty() ? "" : " ") + sub));
            }
        }
        map.put(pos, res);
        return res;
    }
}
