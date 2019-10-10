package com.gmail.imshhui.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to stack, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/"></a>
 * User: liyulin
 * Date: 2019/10/9
 */
public class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> stack;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            queue.add(stack.poll());
        }
        stack.add(x);
        while (!queue.isEmpty()) {
            stack.add(queue.poll());
        }
    }

    /**
     * one queue solution for MyStack
     * @param x
     */
    public void push1(int x) {
        stack.add(x);
        int size = stack.size();
        while (size > 1) {
            stack.add(stack.poll());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */