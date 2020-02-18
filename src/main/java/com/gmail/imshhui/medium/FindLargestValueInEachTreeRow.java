package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 *
 * @see <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">515. Find Largest Value in Each Tree Row</a>
 * User: liyulin
 * Date: 2020/2/18
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        treeHelper(root, map, 0);
        return map.values().stream().collect(Collectors.toList());
    }

    private void treeHelper(TreeNode root, Map<Integer, Integer> map, int height) {
        if (root == null) {
            return;
        }
        int value = map.getOrDefault(height, Integer.MIN_VALUE);
        // bad case: [-2147483648]
        map.put(height, root.val > value ? root.val : value);
        treeHelper(root.left, map, height + 1);
        treeHelper(root.right, map, height + 1);
    }
}
