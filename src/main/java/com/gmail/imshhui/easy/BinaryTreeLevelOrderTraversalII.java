package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/"></a>
 * User: liyulin
 * Date: 2019/8/20
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelHelper(list, root, 0);
        return list;
    }

    private void levelHelper(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height == list.size()) {
            list.add(0, new ArrayList<>());
        }
        levelHelper(list, root.left, height + 1);
        levelHelper(list, root.right, height + 1);
        list.get(list.size() - height - 1).add(root.val);
    }
}
