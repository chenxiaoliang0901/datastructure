package com.study.leetcode;

/**
 * 这个数列有个十分明显的特点，那是：前面相邻两项之和，构成了后一项
 */
public class 斐波那契 {

    public static void main(String[] args) {
        int n=6;
        System.out.println(fbnci(n));
    }
    public static int fbnci(int n){
        if (n==1){
            return 1;
        }else if (n==0){
            return 0;
        }else {
            return fbnci(n-1)+fbnci(n-2);
        }

    }

}
