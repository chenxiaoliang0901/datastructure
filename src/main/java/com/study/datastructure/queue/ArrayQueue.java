package com.study.datastructure.queue;


public class ArrayQueue {
    public static void main(String[] args) {
        Queue queue=new Queue(4);
        queue.put(3);
        queue.put(2);
        queue.put(5);
        queue.put(6);
        System.out.println(queue.get());
        System.out.println(queue.get());
        queue.show();

    }


    static class Queue {


        private int maxSize; //队列最大容量
        private int front; //队列头
        private int rear; //队列尾
        private int[] arr;

        /**
         * 构造函数，用来初始化队列
         *
         * @param maxSize
         */
        public Queue(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[this.maxSize];
            this.front = -1; //指向队列头部，分析出 front 是指向队列头的前一个位置.
            this.rear = -1; //指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {

            return front == rear;
        }

        public int get() {
            if (isEmpty()) {
                System.out.println("队列是空的，不能取数据");
                throw new RuntimeException("队列是空的，不能取数据");
            }
            front++;
            return arr[front];
        }

        public void put(int value) {
            if (isFull()) {
                System.out.println("队列已满，不能存数据");
                return;
            }
            rear++;
            arr[rear] = value;
        }

        public void show() {
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
        }

    }
}