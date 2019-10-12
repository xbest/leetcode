package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-paths/">257. Binary Tree Paths</a>
 * User: liyulin
 * Date: 2019/10/12
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        treeHelper(root, list, "");
        return list;
    }

    private void treeHelper(TreeNode root, List<String> list, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(path + root.val);
        } else {
            treeHelper(root.left, list, path + root.val + "->");
            treeHelper(root.right, list, path + root.val + "->");
        }
    }
}
