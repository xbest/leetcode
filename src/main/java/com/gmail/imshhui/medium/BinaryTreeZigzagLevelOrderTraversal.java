package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/"></a>
 * User: liyulin
 * Date: 2019/8/19
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        if (height % 2 == 0) {
            ret.get(height).add(root.val);
        } else {
            ret.get(height).add(0, root.val);
        }
        levelHelper(ret, root.left, height + 1);
        levelHelper(ret, root.right, height + 1);
    }
}
