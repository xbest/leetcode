package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/"></a>
 * User: liyulin
 * Date: 2019/8/21
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
}
