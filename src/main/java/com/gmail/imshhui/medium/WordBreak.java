package com.gmail.imshhui.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * @see <a href="https://leetcode.com/problems/word-break/"></a>
 * User: liyulin
 * Date: 2019/9/16
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] result = {0};
        backtrace(s, wordDict, 0, result, new HashSet<>());
        return result[0] == 1;
    }

    // use set to memory the visited index to avoid the Time Limit Exceeded case
    private void backtrace(String s, List<String> wordDict, int pos, int[] result, Set<Integer> set) {
        if (set.contains(pos)) {
            return;
        }
        if (pos == s.length()) {
            result[0] = 1;
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (wordDict.contains(s.substring(pos, i + 1))) {
                    backtrace(s, wordDict, i + 1, result, set);
                } else {
                    set.add(pos);
                }
            }
            set.add(pos);
        }
    }
}
