package com.study.datastructure.tree;


public class BinaryTree<Key extends Comparable<Key>, Value> {

    //根节点
    public Node root;
    public int N;

    //插入节点
    public void put(Key key, Value value) {
        root = put(null, key, value);

    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;

    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }

        //x树不为null

        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right, key);

        } else if (cmp < 0) {
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left, key);
        } else {
            //如果key等于x结点的键，就找到了键为key的结点，只需要返回x结点的值即可
            return x.value;
        }

    }

    //删除指定节点
    public void delete(Key key) {
        delete(root, key);

    }

    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;


            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    //变换n结点即可
                    n = n.left;
                }
            }

            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;
        }

        return x;


    }


    public class Node {
        public Node left;
        public Node right;
        public Key key;
        public Value value;

        public Node(Key key, Value value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }


}


