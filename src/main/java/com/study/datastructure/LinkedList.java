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
        //删除节点
//        singleLinkedList.delete(4);
        singleLinkedList.list();
        System.out.println("节点有效的个数:"+singleLinkedList.valid());
//        System.out.println("倒数第k个几点为:"+singleLinkedList.findIndex(1));
        System.out.println("反转链表:");

        HeroNode temp =singleLinkedList.reverse();

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

class SingelLinkedList {
    //初始化英雄节点
    //创建head ,头节点不存放任何数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 单链表常见面试题
     * 单链表的反转
     */
    public HeroNode reverse(){

        //新建一个空链表
        HeroNode newHeroNode=new HeroNode(0, "", "");

        //原链表的当前节点
        HeroNode cur=head.next;
        //原链表的下一个节点
        HeroNode next=null;

        while (true){
            if(cur==null) break;
            next=cur.next;

            cur.next=newHeroNode.next;
            newHeroNode.next=cur;
            cur=next;
        }

        return newHeroNode;
    }

    /**
     * 单链表常见面试题
     * 求单链表中有效节点的个数
     * @param
     */
    public int valid(){

        HeroNode temp=head;
        int count=0;
        while (true){
            if(temp.next==null) break;
            count++;
            temp=temp.next;
        }
        return count;
    }

    /**
     * 单链表常见面试题
     * 查找单链表中的倒数第k个结点
     * @param
     */
    public HeroNode findIndex(int deindex){
        //获取链表长度
        int length=valid()+1;
        if(deindex<=0 || deindex>length) return null;
        //获取正数是第几个节点
        int index=length-deindex;
        HeroNode temp=head;
        for (int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }


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