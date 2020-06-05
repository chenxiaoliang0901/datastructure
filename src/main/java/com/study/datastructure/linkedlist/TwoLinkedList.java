package com.study.datastructure.linkedlist;

public class TwoLinkedList {

    public static void main(String[] args) {

        DoubleLinkedList<DoubleHeroNode> doubleLinkedList = new DoubleLinkedList<DoubleHeroNode>();

        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        DoubleHeroNode hero5 = new DoubleHeroNode(4, "林", "豹子");

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        System.out.println("遍历节点：");
        doubleLinkedList.list();



    }
}



class DoubleLinkedList<E> implements LindedList<E> {

    //创建第一个节点 first

    DoubleHeroNode head =new DoubleHeroNode(0,null,null);

    public void add(E heroNode) {
//        DoubleHeroNode cur=((DoubleHeroNode)heroNode).getNext();
            DoubleHeroNode cur=head;
            while (true){
                if (cur.getNext()==null){

                    cur.setNext((DoubleHeroNode) heroNode);

                    ((DoubleHeroNode) heroNode).setPre(cur);
                    break;

                }
                cur=cur.getNext();

            }
    }

    public void addOrder(E heroNode) {

    }

    public void list() {
        DoubleHeroNode cur=head;
        while (cur.getNext() != null) {
            System.out.println(cur);
            cur = cur.getNext();

        }
    }
}

/**
 * 链表接口
 * 定义标准接口方法
 */
interface LindedList<E>{
    /**
     *添加节点
     * 无序
     */
    public void add(E heroNode);

    /**
     * 添加有序节点
     * @param heroNode
     */
    public void addOrder(E heroNode);

    /**
     * 遍历
     *
     */
    public void list();

}

/**
 *
 * 创建节点对象
 */
class DoubleHeroNode{
    private int no;
    private String name;
    private String nickname;
    private DoubleHeroNode next; // 下一个节点
    private DoubleHeroNode pre; // 上一个节点

    public DoubleHeroNode(int no, String name, String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public DoubleHeroNode getNext() {
        return next;
    }

    public void setNext(DoubleHeroNode next) {
        this.next = next;
    }

    public DoubleHeroNode getPre() {
        return pre;
    }

    public void setPre(DoubleHeroNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", 前节点为:" +pre + '\''
                ;
    }
}