package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/"></a>
 * User: liyulin
 * Date: 2019/8/20
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < postorder.length; i++) {
            list.add(postorder[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return rootHelper(list, map, 0, inorder.length - 1);
    }

    private TreeNode rootHelper(List<Integer> list, Map<Integer, Integer> map, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int value = list.remove(list.size() - 1);
        TreeNode root = new TreeNode(value);
        // get the root location
        int i = map.get(value);
        // First, recursive the right tree. Secondly, recursive the left tree, since this is postorder
        root.right = rootHelper(list, map, i + 1, inEnd);
        root.left = rootHelper(list, map, inStart, i - 1);
        return root;
    }
}
