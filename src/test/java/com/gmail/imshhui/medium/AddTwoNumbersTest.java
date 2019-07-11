package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;
import org.junit.Before;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/7/25
 */
public class AddTwoNumbersTest {
    private ListNode l1;
    private ListNode l2;
    private AddTwoNumbers client = new AddTwoNumbers();

    @Before
    public void initListNode() {
        l1 = listNode(1);
//        l1.next = listNode(4);
//        l1.next.next = listNode(3);
        l2 = listNode(9);
        l2.next = listNode(9);
//        l2.next.next = listNode(4);
    }

    @Test
    public void addTwoNumbersTest() {
        ListNode head = client.addTwoNumbers(l1, l2);
        System.out.println(head);
    }

    private ListNode listNode(int val) {
        return new ListNode(val);
    }
}
