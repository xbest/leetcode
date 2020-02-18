package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 *
 * @see <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">501. Find Mode in Binary Search Tree</a>
 * User: liyulin
 * Date: 2020/2/18
 */
public class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = {0};
        List<Integer> list = new ArrayList<>();
        treeHelper(root, map, max);
        map.entrySet().forEach(entry -> {
            if (entry.getValue() == max[0]) list.add(entry.getKey());
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void treeHelper(TreeNode node, Map<Integer, Integer> map, int[] max) {
        if (node == null) {
            return;
        }
        Integer key = node.val;
        Integer value = map.getOrDefault(key, 0) + 1;
        map.put(key, value);
        max[0] = Math.max(max[0], value);
        treeHelper(node.left, map, max);
        treeHelper(node.right, map, max);
    }
}
