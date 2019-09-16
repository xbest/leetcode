package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Example 1:
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 *
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/"></a>
 * User: liyulin
 * Date: 2019/9/16
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        return clone(head, new HashMap<>());
    }

    private Node clone(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node tempNode = new Node();
        map.put(node.val, tempNode);
        tempNode.val = node.val;
        tempNode.next = clone(node.next, map);
        tempNode.random = clone(node.random, map);
        return tempNode;
    }

    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
