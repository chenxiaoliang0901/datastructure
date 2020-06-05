package com.study.datastructure.queue;


public class CircleArrayQueue {
    public static void main(String[] args) {
        Queue queue=new Queue(4);
        queue.put(3);
        queue.put(2);
        queue.put(5);
        System.out.println(queue.get());

        queue.put(9);
        System.out.println(queue.get());

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
            this.front = 0; //变量的含义做一个调整: front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
            this.rear = 0; //变量的含义做一个调整:rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定
        }

        public boolean isFull() {
            return (rear+1)%maxSize == front;
        }

        public boolean isEmpty() {

            return front == rear;
        }

        public int get() {
            if (isEmpty()) {
                System.out.println("队列是空的，不能取数据");
                throw new RuntimeException("队列是空的，不能取数据");
            }
            int value= arr[front];
            front=(front+1)%maxSize;
            return value;

        }

        public void put(int value) {
            if (isFull()) {
                System.out.println("队列已满，不能存数据");
                return;
            }
            arr[rear] = value;
            //将 rear 后移, 这里必须考虑取模
            rear = (rear + 1) % maxSize;
        }

        public void show() {
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
        }

    }
}