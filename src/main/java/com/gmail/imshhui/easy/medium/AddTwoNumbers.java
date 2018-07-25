package com.gmail.imshhui.easy.medium;

import java.util.Objects;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = null;
        int carry = 0;
        boolean isHead = true;

        if (Objects.isNull(l1) && Objects.isNull(l2)) {
            return null;
        }
        if (Objects.isNull(l1) && Objects.nonNull(l2)) {
            return l2;
        }
        if (Objects.isNull(l2) && Objects.nonNull(l1)) {
            return l1;
        }
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            if (isHead) {
                head = result = temp;
                isHead = false;
            } else {
                result.next = temp;
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (Objects.isNull(l1) && Objects.isNull(l2) && carry > 0) {
            result.next = new ListNode(carry);
        }
        // [2,3], [6,7,8]
        while (Objects.nonNull(l1)) {
            int sum = l1.val + carry;
            carry = sum / 10;
            if (carry == 0) {
                l1.val = sum;
                result.next = l1;
                break;
            }
            // [2,3], [6,8,9]
            result.next = new ListNode(sum % 10);
            result = result.next;
            l1 = l1.next;
            if (Objects.isNull(l1)) {
                // [1], [9,9,9]
                result.next = new ListNode(carry);
            }
        }
        while (Objects.nonNull(l2)) {
            int sum = l2.val + carry;
            carry = sum / 10;
            if (carry == 0) {
                l2.val = sum;
                result.next = l2;
                break;
            }
            result.next = new ListNode(sum % 10);
            result = result.next;
            l2 = l2.next;
            if (Objects.isNull(l2)) {
                result.next = new ListNode(carry);
            }
        }
        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode q = l1;
        ListNode p = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        int carry = 0;
        while (Objects.nonNull(q) || Objects.nonNull(p)) {
            int x = Objects.isNull(q) ? 0 : q.val;
            int y = Objects.isNull(p) ? 0 : p.val;
            int sum = x + y + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            q = Objects.isNull(q) ? null : q.next;
            p = Objects.isNull(p) ? null : p.next;
        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
