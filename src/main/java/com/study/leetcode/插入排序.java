package com.study.leetcode;

/**
 *    将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *
 *     从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 *     （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class 插入排序 {

    public static void main(String[] args) {

        int[] arr={4,1,6,8,2};
        insertSort(arr);
        for (int i:arr){
            System.out.println(i);
        }

    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            int j = i;
            while (j > 0 && temp < arr[j - 1]) {

                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }


        }


    }


}
