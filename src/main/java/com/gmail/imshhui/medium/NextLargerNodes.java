package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为n的链表head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 *
 * @Author liyulin
 * @Date 2023/4/13 14:57
 * @Version 1.0
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int[] res = new int[nodes.size()];
        for (int i = 0; i < res.length; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j) > nodes.get(i)) {
                    res[i] = nodes.get(j);
                    break;
                }
            }
        }
        return res;
    }

    public int[] nextLargerNodes1(ListNode head) {
        ListNode outside = head;
        List<Integer> res = new ArrayList<>();
        while (outside != null) {
            int val = outside.val;
            ListNode inside = outside;
            boolean found = false;
            while (inside != null) {
                if (val < inside.val) {
                    res.add(inside.val);
                    found = true;
                    break;
                }
                inside = inside.next;
            }
            if (!found) {
                res.add(0);
            }
            outside = outside.next;
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] nextLargerNodes2(ListNode head) {

        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[nodes.size()];

        for (int j = 0; j < nodes.size(); j++) {
            while (!stack.isEmpty() && stack.peek()[0] < nodes.get(j)) {
                res[stack.pop()[1]] = nodes.get(j);
            }
            stack.push(new int[] {nodes.get(j), j});
        }

        return res;
    }

    public static void main(String[] args) {
        NextLargerNodes nextLargerNodes = new NextLargerNodes();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        nextLargerNodes.nextLargerNodes2(head);
    }
}
