package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 *
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 *
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 *
 * Output: "45"
 *
 * @see <a href="https://leetcode.com/problems/reconstruct-original-digits-from-english/">423. Reconstruct Original Digits from English</a>
 * User: liyulin
 * Date: 2019/11/19
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        //zero, one, two, three, four, five, six, seven, eight, nine
        List<Integer> list = new ArrayList<>();
        String[] words = {"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
        int[] digits = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int i = 0;
        while (i < 10) {
            if (transform(list, count, words[i], digits[i])) {
                continue;
            } else {
                i++;
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(integer -> sb.append(integer));
        return sb.toString();
    }

    private boolean transform(List<Integer> list, int[] count, String word, int digit) {
        boolean checkWord = true;
        for (int i = 0; i < word.length(); i++) {
            checkWord = checkWord && count[word.charAt(i) - 'a'] != 0;
        }
        if (checkWord) {
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']--;
            }
            list.add(digit);
        }
        return checkWord;
    }
}
