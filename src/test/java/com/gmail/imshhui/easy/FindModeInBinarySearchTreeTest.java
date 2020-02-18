package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2020/2/18
 */
public class FindModeInBinarySearchTreeTest {
    FindModeInBinarySearchTree client = new FindModeInBinarySearchTree();
    @Test
    public void findModeTest(){
        TreeNode root = new TreeNode(1);
        TreeNode subNode=new TreeNode(2);
        root.right=subNode;
        subNode.left = new TreeNode(2);
        client.findMode(root);
    }

}
