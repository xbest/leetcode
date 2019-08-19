package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/"></a>
 * User: liyulin
 * Date: 2019/8/19
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> ret = new ArrayList<>();
        levelHelper(ret, root, 0);
        return ret;
    }

    private void levelHelper(List<List<Integer>> ret, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height == ret.size()) {
            ret.add(new ArrayList<>());
        }
        ret.get(height).add(root.val);
        levelHelper(ret, root.left, height + 1);
        levelHelper(ret, root.right, height + 1);
    }
}
