package com.study.leetcode.递归回溯;

public class Queue8 {

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d 解法", count);

    }
    static int count=0;
    //定义共有8个皇后
    static int max = 8;
    //定义数组
    static int[] array = new int[max];

    public static void check(int n) {
        //表示所有的皇后已放置完
        if (n == 8) {
            print();
            return;
        }
        for (int i=0;i<max;i++){
            array[n]=i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    /**
     * @param n 表示有几个皇后
     * @return
     */
    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //array[i]==array[n] 表示同一列
            //Math.abs(i-n)==Math.abs(array[i]-array[n]) 表示同一斜线
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {

                return false;
            }
        }

        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    public static void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
