package com.gmail.imshhui.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an Iterator class interface with methods: next() and hasNext(),
 * design and implement a PeekingIterator that support the peek() operation
 * -- it essentially peek() at the element that will be returned by the next call to next().
 *
 * Example:
 *
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 *
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 *
 * @see <a href="https://leetcode.com/problems/peeking-iterator/">284. Peeking Iterator</a>
 * User: liyulin
 * Date: 2019/10/15
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Queue<Integer> list;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        list = new LinkedList<>();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        Integer next = list.peek();
        if (next != null) {
            return next;
        }
        if (hasNext()) {
            next = iterator.next();
            list.add(next);
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = list.poll();
        return next == null && iterator.hasNext() ? iterator.next() : next;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty() || iterator.hasNext();
    }
}
