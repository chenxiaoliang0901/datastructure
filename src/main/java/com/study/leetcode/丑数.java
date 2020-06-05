package com.study.leetcode;

/**
 * leetcode 面试题17.09
 * 第 k 个数
 *
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 */
class 丑数 {

    public static int getKthMagicNumber(int k){
        int[] array = new int[k];
        int i3=0;
        int i5=0;
        int i7=0;
        array[0]=1;
        for (int i=1;i<k;i++){
            array[i]=Math.min(Math.min(3*array[i3],5*array[i5]),7*array[i7]);
            if (array[i]==3*array[i3]) i3++;
            if (array[i]==5*array[i5]) i5++;
            if (array[i]==7*array[i7]) i7++;
        }
        return array[k-1];
    }

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(12));
    }
}