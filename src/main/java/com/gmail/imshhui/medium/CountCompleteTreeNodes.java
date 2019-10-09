package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 *
 * @see <a href="https://leetcode.com/problems/count-complete-tree-nodes/"></a>
 * User: liyulin
 * Date: 2019/10/9
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        levelHelper(root, map, 0);
        int nodes = 0;
        for (Integer value : map.values()) {
            nodes = nodes + value;
        }
        return nodes;
    }

    private void levelHelper(TreeNode root, Map<Integer, Integer> map, int high) {
        if (root == null) {
            return;
        }
        if (map.containsKey(high)) {
            int value = map.get(high);
            map.put(high, ++value);
        } else {
            map.put(high, 1);
        }
        levelHelper(root.left, map, high + 1);
        levelHelper(root.right, map, high + 1);
    }

    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
}
