package com.gmail.imshhui.medium;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * User: liyulin
 * Date: 2019/7/1
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<String, Integer> keyNumsMap = new HashMap<>();
        List<TwoSumItem> twoSumItemList = buildTwoSumItems(nums, keyNumsMap);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < twoSumItemList.size(); i++) {
            for (int j = i + 1; j < twoSumItemList.size(); j++) {
                if (twoSumItemList.get(i).value + twoSumItemList.get(j).value == target) {
                    List<Integer> tempResult = new ArrayList<>();
                    Map<String, Integer> tempMap = new HashMap<>();
                    tempResult.add(twoSumItemList.get(i).i);
                    tempResult.add(twoSumItemList.get(i).j);
                    tempResult.add(twoSumItemList.get(j).i);
                    tempResult.add(twoSumItemList.get(j).j);
                    for (Integer integer : tempResult) {
                        String tempKey = String.valueOf(integer);
                        Integer tempKeyNums = tempMap.get(tempKey);
                        tempMap.put(tempKey, tempKeyNums == null ? 1 : tempKeyNums + 1);
                    }
                    boolean canAdd = true;
                    for (String k : tempMap.keySet()) {
                        // can not over the original key nums
                        if (tempMap.get(k) > keyNumsMap.get(k)) {
                            canAdd = false;
                        }
                    }
                    if (canAdd) {
                        Collections.sort(tempResult);
                        set.add(tempResult);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    public List<TwoSumItem> buildTwoSumItems(int[] nums, Map<String, Integer> keyNumsMap) {
        List<TwoSumItem> twoSumItemList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoSumItemList.add(new TwoSumItem(nums[i], nums[j]));
            }
            String key = String.valueOf(nums[i]);
            Integer keyNums = keyNumsMap.get(key);
            keyNumsMap.put(key, keyNums == null ? 1 : keyNums + 1);
        }
        Collections.sort(twoSumItemList);
        return twoSumItemList;
    }

    private class TwoSumItem implements Comparable {
        private int value;
        private int i;
        private int j;

        public TwoSumItem(int i, int j) {
            this.i = i;
            this.j = j;
            this.value = i + j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TwoSumItem that = (TwoSumItem) o;
            return value == that.value &&
                    i == that.i &&
                    j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, i, j);
        }

        @Override
        public int compareTo(Object o) {
            TwoSumItem that = (TwoSumItem) o;
            // Comparison method violates its general contract
            if (this == o || value == that.value) return 0;
            return value > that.value ? 1 : -1;
        }
    }
}
