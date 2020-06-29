package com.study.leetcode.二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树后序遍历 {


    //迭代法


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        while (!stack.empty() || root != null) {
            while (root != null) {
                list.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return list;
    }


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }
}
