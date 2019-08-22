package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Example:
 *
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/"></a>
 * User: liyulin
 * Date: 2019/8/21
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        List<Stack<Node>> list = new ArrayList<>();
        connectHelper(root, list, 0);
        return root;
    }

    private void connectHelper(Node root, List<Stack<Node>> list, int height) {
        if (root == null) {
            return;
        }
        if (list.size() == height) {
            list.add(new Stack<>());
        }
        Stack<Node> stack = list.get(height);
        if (!stack.isEmpty()) {
            stack.pop().next = root;
        }
        stack.push(root);
        connectHelper(root.left, list, height + 1);
        connectHelper(root.right, list, height + 1);
    }
}
