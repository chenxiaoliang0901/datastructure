package com.study.leetcode.二叉树;

import java.util.HashMap;

public class 重建二叉树 {

    public static void main(String[] args) {

        重建二叉树 bt = new 重建二叉树();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        bt.build(preorder,inorder);

    }

    int preIndex = 0;
    int[] preorder;
    int[] inorder;

    HashMap<Integer, Integer> inmap = new HashMap<>();


    private TreeNode build(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int s = 0;
        for (int a : inorder) {
            inmap.put(a, s);
            s++;
        }

        return helper(0,inorder.length-1);

    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        int v = preorder[preIndex];


        TreeNode node = new TreeNode(v);
        preIndex++;

        int index = inmap.get(v);

        node.left = helper(left, index - 1);
        node.right = helper(index + 1, right);

        return node;


    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
