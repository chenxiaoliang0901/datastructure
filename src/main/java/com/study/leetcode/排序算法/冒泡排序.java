package com.study.leetcode.排序算法;

/**
 * 冒泡排序(Bubble Sorting)的基本思想是:
 * 通过对待排序序列从前向后(从下标较小的元素开始),
 * 依次比较 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
 */

public class 冒泡排序 {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 9, 2, 6};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void bubbleSort(int[] arr) {
        int temp=0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
