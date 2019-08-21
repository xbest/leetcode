package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/path-sum-ii/"></a>
 * User: liyulin
 * Date: 2019/8/21
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        pathHelper(list, new ArrayList<>(), root, 0, sum);
        return list;
    }

    private void pathHelper(List<List<Integer>> list, List<Integer> temp, TreeNode root, int path, int sum) {
        if (root == null) {
            return;
        }
        path = path + root.val;
        temp.add(root.val);
        if (path == sum && root.left == null && root.right == null) {
            list.add(new ArrayList<>(temp));
            // when matched, remove the last integer also.
            temp.remove(temp.size() - 1);
            return;
        }
        pathHelper(list, temp, root.left, path, sum);
        pathHelper(list, temp, root.right, path, sum);
        temp.remove(temp.size() - 1);
    }

    private void pathHelper2(List<List<Integer>> list, List<Integer> temp, TreeNode root, int path, int sum) {
        if (root == null) {
            return;
        }
        path = path + root.val;
        temp.add(root.val);
        if (path == sum && root.left == null && root.right == null) {
            list.add(new ArrayList<>(temp));
        } else {
            pathHelper(list, temp, root.left, path, sum);
            pathHelper(list, temp, root.right, path, sum);
        }
        temp.remove(temp.size() - 1);
    }
}
