package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 * @see <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">513. Find Bottom Left Tree Value</a>
 * User: liyulin
 * Date: 2020/2/18
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = {0};
        treeHelper(root, map, 0, max);
        return map.get(max[0]);
    }

    private void treeHelper(TreeNode root, Map<Integer, Integer> map, int height, int[] max) {
        if (root == null) {
            return;
        }
        max[0] = Math.max(max[0], height);
        if (!map.containsKey(height)) {
            map.put(height, root.val);
        }
        treeHelper(root.left, map, height + 1, max);
        treeHelper(root.right, map, height + 1, max);
    }
}
