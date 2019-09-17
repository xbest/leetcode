package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/"></a>
 * User: liyulin
 * Date: 2019/9/17
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeHelper(root, list);
        return list;
    }

    private void treeHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        treeHelper(root.left, list);
        treeHelper(root.right, list);
    }
}
