package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-bst/">449. Serialize and Deserialize BST</a>
 * User: liyulin
 * Date: 2019/11/29
 */
public class SerializeAndDeserializeBST {
    private static final String NULL = "null";
    private static final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(SEP);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (NULL.equals(data)) {
            return null;
        }
        String[] strings = data.split(SEP);
        Queue<Integer> queue = new LinkedList<>();
        for (String s : strings) {
            queue.offer(Integer.valueOf(s));
        }
        return getNode(queue);
    }

    private TreeNode getNode(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallerQueue = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallerQueue.offer(queue.poll());
        }
        root.left = getNode(smallerQueue);
        root.right = getNode(queue);
        return root;
    }
}
