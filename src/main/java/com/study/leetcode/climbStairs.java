package com.study.leetcode;

/**
 * 爬楼梯
 */
public class climbStairs {


    public static void main(String[] args) {
        int n=10; //楼梯数
        int x=2; //上一级楼梯组合数
        int y=1; //上两级组合数
        int m=0; //n层楼梯组合数

        for (int i=3;i<=n;i++){
            m=x+y;
//            System.out.println("楼梯数："+i+",种类数："+m);
            y=x;
            x=m;
        }
        System.out.println("楼梯数："+n+",种类数："+m);


    }
}
