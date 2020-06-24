package com.study.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树前序遍历 {

    //迭代法

    public List<Integer> preorder(TreeNode root) {


        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pollLast();

            res.add(cur.value);

            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);


        }

        return res;


    }

    //递归
    public List preErgodic(TreeNode root) {
        LinkedList<Integer> q = new LinkedList<>();
        preErgodic(root, q);
        return q;
    }

    public void preErgodic(TreeNode root, Queue<Integer> q) {
        if (root == null) return;
        q.add(root.value);
        if (root.left != null) preErgodic(root.left, q);
        if (root.right != null) preErgodic(root.right, q);
    }


    class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


}
