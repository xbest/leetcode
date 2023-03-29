package com.gmail.imshhui.medium;

import java.util.Arrays;

/**
 * 1641. 统计字典序元音字符串的数目
 * https://leetcode.cn/problems/count-sorted-vowel-strings/solution/tong-ji-zi-dian-xu-yuan-yin-zi-fu-chuan-sk7y1/
 *
 * @Author liyulin
 * @Date 2023/3/29 19:57
 * @Version 1.0
 */
public class CountVowelStrings {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }

}
