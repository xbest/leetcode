package com.gmail.imshhui.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * @see <a href="https://leetcode.com/problems/min-stack/"></a>
 * User: liyulin
 * Date: 2019/9/18
 */
public class MinStack {
    private LinkedList<Integer> list;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return Collections.min(list);
    }
}

class MinStack1 {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack1() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
