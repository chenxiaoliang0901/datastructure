package com.study.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTreeDemo bt = new BinaryTreeDemo();

        bt.put(3);
        bt.put(2);
        bt.put(5);
        bt.put(4);
        bt.put(6);
        System.out.println(root);
        bt.delete(5);

        System.out.println(root);
        //前序遍历
        Queue queue = bt.preErgodic();
        while (queue.size() > 0) {
            System.out.printf("%s\t", queue.poll());
        }
        System.out.println("层次遍历结果：");
        //层次遍历
        Queue queue1 = bt.layerErgodic();
        while (queue1.size() > 0) {
            System.out.printf("%s\t", queue1.poll());
        }
        System.out.println("二叉树最大深度为：");

        System.out.println(bt.maxDepth(root));

        Node x=bt.mirrorTree(root);
        System.out.println(x);

    }


    static Node root;

    //二叉树镜像
    private Node mirrorTree(Node x) {
        if (x == null) return null;
        Node temp = x.left;
        x.left = mirrorTree(x.right);
        x.right = mirrorTree(temp);
        return x;
    }

    //获取二叉树最大深度
    public int maxDepth(Node x) {

        if (x == null) return 0;

        return Math.max(maxDepth(x.left), maxDepth(x.right)) + 1;

    }


    //前序遍历
    public Queue preErgodic() {
        Queue<Object> q = new LinkedList<>();
        preErgodic(root, q);
        return q;
    }

    public void preErgodic(Node root, Queue<Object> q) {
        if (root == null) return;
        q.add(root.value);
        if (root.left != null) preErgodic(root.left, q);
        if (root.right != null) preErgodic(root.right, q);
    }

    //层序遍历
    public Queue layerErgodic() {
        Queue<Object> valueQueue = new LinkedList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node x = nodeQueue.poll();
            valueQueue.add(x.value);
            if (x.left != null) {
                nodeQueue.add(x.left);
            }
            if (x.right != null) {
                nodeQueue.add(x.right);
            }
        }


        return valueQueue;
    }


    public void put(int value) {
        root = put(root, value);

    }

    public Node put(Node x, int value) {
        if (x == null) {
            return new Node(value);
        }
        if (value > x.value) {
            x.right = put(x.right, value);
        } else if (value < x.value) {
            x.left = put(x.left, value);
        } else {
            x.value = value;
        }
        return x;

    }

    private int get(int value) {
        return get(root, value);
    }

    private int get(Node x, int value) {
        if (x == null) return -1;
        if (value > x.value) {
            return get(x.right, value);
        } else if (value < x.value) {
            return get(x.left, value);
        } else {
            return x.value;
        }
    }

    private void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node x, int value) {
        if (x == null) return null;
        if (value > x.value) {
            x.right = delete(x.right, value);
        } else if (value < x.value) {
            x.left = delete(x.left, value);
        } else {

            //找到要删除的节点了

            if (x.left == null) {
                return x.right;
            }
            //如果要删除几点的右几点为空，那么就返回左节点
            if (x.right == null) {
                return x.right;
            }

            //如果左右都不为空的话，那么就找到右子树中最小的节点
            Node minRight = x.right;
            while (minRight.left != null) {
                minRight = minRight.left;
            }

            //删除minRight
            Node n = x.right;
            if (n.left == null) {
                n.left = x.left;
                x = n;
            } else {
                while (n.left != null) {
                    if (n.left.left == null) {
                        n.left = null;
                    } else {
                        n = n.left;
                    }
                }
                minRight.left = x.left;
                //让x结点的右子树成为minNode的右子树
                minRight.right = x.right;
                //让x结点的父结点指向minNode
                x = minRight;

            }

        }

        return x;

    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
