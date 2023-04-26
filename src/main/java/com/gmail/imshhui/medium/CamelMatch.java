package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 1023. 驼峰式匹配
 * 给你一个字符串数组 queries，和一个表示模式的字符串 pattern，请你返回一个布尔数组 answer 。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 *
 * 如果可以将小写字母插入模式pattern 得到待查询项 query，那么待查询项与给定模式串匹配。可以在任何位置插入每个字符，也可以不插入字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/camelcase-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author liyulin
 * @Date 2023/4/26 10:04
 * @Version 1.0
 */
public class CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        for (String query : queries) {
            Stack<String> patternStack = new Stack<>();
            for (int i = 0; i < pattern.length(); i++) {
                patternStack.push(String.valueOf(pattern.charAt(i)));
            }
            boolean match = true;
            boolean localMatch = false;
            for (int i = query.length() - 1; i >= 0; i--) {
                if (!patternStack.isEmpty() && Objects.equals(patternStack.peek(), String.valueOf(query.charAt(i)))) {
                    patternStack.pop();
                    localMatch = true;
                } else {
                    if (Character.isUpperCase(query.charAt(i))) {
                        match = false;
                        break;
                    }
                }
            }
            res.add(match && localMatch);
        }
        return res;

    }

    public List<Boolean> camelMatch1(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        for (String query : queries) {
            res.add(matched(query, pattern));
        }
        return res;

    }

    private boolean matched(String query, String pattern) {
        int j = 0;
        for (int i = 0; i < query.length(); i++) {
            if (j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                if (Character.isUpperCase(query.charAt(i))) {
                    return false;
                }
            }
        }
        return j == pattern.length();
    }

    public static void main(String[] args) {
        CamelMatch camelMatch = new CamelMatch();
        String[] queries = new String[] {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        camelMatch.camelMatch(queries, pattern);
    }
}
