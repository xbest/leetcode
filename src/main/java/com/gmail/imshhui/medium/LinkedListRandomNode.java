package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 *
 * @see <a href="https://leetcode.com/problems/linked-list-random-node/">382. Linked List Random Node</a>
 * User: liyulin
 * Date: 2019/11/6
 */
public class LinkedListRandomNode {
    private int size;
    private Random random;
    private ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        random = new Random();
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int count = 0;
        int res = 0;
        while (cur != null) {
            int r = random.nextInt(count + 1);
            if (r == count) {
                res = cur.val;
            }
            count++;
            cur = cur.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */