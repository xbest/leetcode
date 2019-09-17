package com.gmail.imshhui.hard;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/"></a>
 * User: liyulin
 * Date: 2019/9/17
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeHelper(root, list);
        return list;
    }

    private void treeHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        treeHelper(root.left, list);
        treeHelper(root.right, list);
        list.add(root.val);
    }
}
