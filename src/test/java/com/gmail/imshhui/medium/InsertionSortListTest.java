package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/18
 */
public class InsertionSortListTest {
    InsertionSortList client = new InsertionSortList();
    @Test
    public void insertionSortList() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        client.insertionSortList(head);
    }
}
