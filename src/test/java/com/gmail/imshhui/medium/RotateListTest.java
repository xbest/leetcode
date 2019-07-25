package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/25
 */
public class RotateListTest {
    RotateList client = new RotateList();

    @Test
    public void rotateList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode ret = client.rotateRight(head, 3);
        System.out.println(ret);
    }
}
