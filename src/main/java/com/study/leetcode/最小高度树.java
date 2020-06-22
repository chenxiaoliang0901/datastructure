package com.study.leetcode;
/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 */

import java.util.Arrays;

public class 最小高度树 {


    public static void main(String[] args) {

        int[] arr={-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(arr));

    }

    static class TreeNode {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode n = new TreeNode(nums[nums.length / 2]);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return n;
    }

}
