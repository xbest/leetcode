package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning/"></a>
 * User: liyulin
 * Date: 2019/9/16
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrace(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(String s, int pos, List<String> temp, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                temp.add(s.substring(pos, i + 1));
                backtrace(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
