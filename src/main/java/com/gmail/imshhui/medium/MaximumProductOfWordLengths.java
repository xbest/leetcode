package com.gmail.imshhui.medium;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * Example 1:
 *
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 *
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 *
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 *
 * @see <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">318. Maximum Product of Word Lengths</a>
 * User: liyulin
 * Date: 2019/10/21
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] bitNum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int num = 0;
            for (int j = 0; j < word.length(); j++) {
                num = num | (1 << word.charAt(j) - 'a');
            }
            bitNum[i] = num;
        }
        int max = 0;
        for (int i = 0; i < bitNum.length; i++) {
            for (int j = i + 1; j < bitNum.length; j++) {
                if ((bitNum[i] & bitNum[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
