package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference
 * between the sum of all left subtree node values and the sum of all right subtree node values.
 * Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 *
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-tilt/">563. Binary Tree Tilt</a>
 * User: liyulin
 * Date: 2020/2/28
 */
public class BinaryTreeTilt {
    private int res;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return res;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        res = res + Math.abs(left - right);
        return root.val + left + right;
    }
}
