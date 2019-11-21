package com.gmail.imshhui.medium;

import java.util.Stack;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 * Example:
 *
 * Input:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 * Explanation for the above example:
 *
 * Given the following multilevel doubly linked list:
 *
 * We should return the following flattened doubly linked list:
 *
 * @see <a href="https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/">430. Flatten a Multilevel Doubly Linked List</a>
 * User: liyulin
 * Date: 2019/11/21
 */
public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                cur.child.prev = cur;
                cur.next = cur.child;
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()) {
                Node childNode = stack.pop();
                childNode.prev = cur;
                cur.next = childNode;
            }
            cur = cur.next;
        }
        return head;
    }

    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
