package com.study.leetcode.排序算法;

/**
 * 选择排序(select sorting)也是一种简单的排序方法。它的基本思想是:第一次从 arr[0]~arr[n-1]中选取最小值，
 * 与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，
 * 第三次从 arr[2]~arr[n-1]中选取最小值，与 arr[2] 交换，...，
 * 第 i 次从 arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，...,
 * 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值， 与 arr[n-2]交换，总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列。
 *
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 2, 6};
        selectSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
