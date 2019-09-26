package com.gmail.imshhui.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * @see <a href="https://leetcode.com/problems/repeated-dna-sequences/"></a>
 * User: liyulin
 * Date: 2019/9/24
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map.keySet().stream().filter(x -> map.get(x) > 1).collect(Collectors.toList());
    }

    public List<String> findRepeatedDnaSequencesBitwise(String s) {
        Set<Integer> all = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = ((sum << 3) | (s.charAt(i) & 7)) & 0x3FFFFFFF;
            if (i < 9) {
                continue;
            }
            if (all.contains(sum)) {
                repeated.add(s.substring(i - 9, i + 1));
            }
            all.add(sum);
        }
        return new ArrayList<>(repeated);
    }

}
