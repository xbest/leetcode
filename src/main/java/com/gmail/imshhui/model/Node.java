package com.gmail.imshhui.model;

import java.util.List;

/**
 * User: liyulin
 * Date: 2019/9/16
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
