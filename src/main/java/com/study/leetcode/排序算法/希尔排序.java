package com.study.leetcode.排序算法;

/**
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序;随着增量逐渐减少，每组包含
 * 的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止
 *
 */
public class 希尔排序 {

    public static void main(String[] args) {

        int[] arr={4,1,6,8,2};
        xiSort(arr);
        for (int i:arr){
            System.out.println(i);
        }

    }

    public static void xiSort(int[] arr) {

        for (int gap = arr.length/2;gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
        }
    }
}
