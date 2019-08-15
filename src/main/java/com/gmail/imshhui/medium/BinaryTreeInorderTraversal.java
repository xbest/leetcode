package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/"></a>
 * User: liyulin
 * Date: 2019/8/14
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }
}
