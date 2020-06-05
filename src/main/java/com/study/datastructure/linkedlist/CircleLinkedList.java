package com.study.datastructure.linkedlist;

/**
 * 单向环形列表
 */
public class CircleLinkedList {

    public static void main(String[] args) {
        CircleSingleLinkedList list=new CircleSingleLinkedList();
        list.add(5);
        list.show();
    }
}


class CircleSingleLinkedList {


    //创建头节点
    ChildNode first = null;


    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * @param startNo
     * 表示从第几个小孩开始数数
     * @param countNum
     * 表示数几下
     * @param nums
     * 表示最初有多少小孩在圈中
     */
    public void countChild(int startNo, int countNum, int nums){
        // 创建要给辅助指针,帮助完成小孩出圈
        ChildNode helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明 helper 指向最后小孩节点
                 break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 k - 1 次
        for (int j=0;j<startNo-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时移动 m - 1 次, 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true){
            if (helper==first){//说明圈中只有一个点
                break;
            }
            for (int j=0;j<countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo()); //这时将 first 指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //

        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());


    }
    /**
     * 添加小朋友
     *
     * @param num 表示有几个小朋友
     */
    public void add(int num) {
        ChildNode cur = first;
        for (int i = 1; i <= num; i++) {
            ChildNode child = new ChildNode(i);
            if (i == 1) {
                first = child;
                first.setNext(first);
                cur = first;

            } else {
                cur.setNext(child);
                child.setNext(first);
                cur = child;
            }
        }
    }

    /**
     * 遍历环形链表
     * 当最后一个节点的next==first时，退出循环
     */
    public void show(){

        ChildNode cur = first;
        while (true){
            System.out.println(cur);
            if(cur.next==first) break;
            cur=cur.getNext();
        }
    }

    /**
     * 内部类
     */
    class ChildNode {
        private int no;
        private ChildNode next;

        public ChildNode(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public ChildNode getNext() {
            return next;
        }

        public void setNext(ChildNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ChildNode{" +
                    "no=" + no +
                    '}';
        }
    }
}