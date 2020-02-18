package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 *
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 * @see <a href="https://leetcode.com/problems/most-frequent-subtree-sum/">508. Most Frequent Subtree Sum</a>
 * User: liyulin
 * Date: 2020/2/18
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = {0};
        treeHelper(root, map, max);
        List<Integer> list = new ArrayList<>();
        map.entrySet().forEach(entry -> {
            if (entry.getValue() == max[0]) {
                list.add(entry.getKey());
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int subtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + subtreeSum(root.left) + subtreeSum(root.right);
    }

    private void treeHelper(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) {
            return;
        }
        int key = subtreeSum(root);
        int value = map.getOrDefault(key, 0) + 1;
        map.put(key, value);
        max[0] = Math.max(max[0], value);
        treeHelper(root.left, map, max);
        treeHelper(root.right, map, max);
    }
}
