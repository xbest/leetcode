package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/"></a>
 * User: liyulin
 * Date: 2019/9/25
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeHelper(root, 0, list);
        return list;
    }

    public void treeHelper(TreeNode root, int height, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (height == list.size()) {
            list.add(height, root.val);
        }
        treeHelper(root.right, height + 1, list);
        treeHelper(root.left, height + 1, list);
    }
}
