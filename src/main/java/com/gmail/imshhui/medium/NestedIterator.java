package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 *
 * @see <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">341. Flatten Nested List Iterator</a>
 * User: liyulin
 * Date: 2019/10/31
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            initList(nestedInteger);
        }
    }

    private void initList(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        } else {
            List<NestedInteger> temp = nestedInteger.getList();
            for (NestedInteger integer : temp) {
                initList(integer);
            }
        }
    }

    @Override
    public Integer next() {
        Integer value = list.get(index);
        index++;
        return value;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
