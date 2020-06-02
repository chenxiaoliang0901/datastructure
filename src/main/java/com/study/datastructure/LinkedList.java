package com.study.datastructure;

public class LinkedList {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(4, "林", "豹子");

        //创建要给链表
        SingelLinkedList singleLinkedList = new SingelLinkedList();


        //无序插入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        //有序插入
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        //修改节点信息
        singleLinkedList.modify(hero5);
        singleLinkedList.delete(4);
        singleLinkedList.list();
        //删除节点

    }

}

class SingelLinkedList {
    //初始化英雄节点
    //创建head ,头节点不存放任何数据
    private HeroNode head = new HeroNode(0, "", "");

    //删除节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点 temp
                flag = true;
                break;
            }
            temp = temp.next; //temp 后移，遍历
        }
        //判断 flag
        if (flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    //修改节点信息
    public void modify(HeroNode heroNode) {

        HeroNode temp = head;
        while (true) {
            if (temp.no == heroNode.no) {//表示已找到该节点
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                break;
            }
            if (temp.next == null) {
                System.out.println("该节点不存在");
                break;
            }
            temp = temp.next;
        }

    }

    //添加节点（无序）
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        System.out.println(head.next);
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;

    }

    //添加节点（有序）
    public void addByOrder(HeroNode heroNode) {
        //头节点不能改变，所以创建临时节点
        HeroNode temp = head;

        //true表示节点重复，false表示节点不重复
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no > heroNode.no) {//如果传进来的heroNode.no比temp的下一个节点小，说明heroNode就在temp后面
                break;

            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("该节点%s已存在，无法插入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示链表[遍历]
    public void list() {

        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }

}


class HeroNode {
    int no;
    String name;
    String nickname;
    HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    @Override
    public String toString() {
        return "no:" + no + "\tname:" + name + "\tnickname:" + nickname;
    }
}