package com.gmail.imshhui.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2404. 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 *
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1
 * https://leetcode.cn/problems/most-frequent-even-element/
 *
 * @Author liyulin
 * @Date 2023/4/13 10:13
 * @Version 1.0
 */
public class MostFrequentEven {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxNum = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                int count = map.getOrDefault(num, 0);
                map.put(num, ++count);
                if (maxCount < count) {
                    maxNum = num;
                }
                if (maxCount == count) {
                    maxNum = Math.min(maxNum, num);
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxNum;
    }

    public static int mostFrequentEven1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int[] odds = Arrays.stream(nums).filter(e -> e % 2 == 0).toArray();

        if (odds.length == 0) {
            return -1;
        }
        int preCount = 0;
        int currentCount = 1;
        int mostNum = -1;
        for (int i = 1; i < odds.length; i++) {
            if (odds[i] == odds[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > preCount) {
                    mostNum = odds[i - 1];
                    preCount = currentCount;
                }
                currentCount = 1;
            }
        }
        return currentCount > preCount ? odds[odds.length - 1] : mostNum;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {0, 0};
        int[] nums = {0, 2};
//        int[] nums = {0, 1, 2, 2, 4, 4, 1};
//        int[] nums = {4, 4, 4, 9, 2, 4};
//        int[] nums = {29,47,21,41,13,37,25,7};
        System.out.println(mostFrequentEven1(nums));
    }
}
