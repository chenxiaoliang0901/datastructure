package com.study.leetcode.排序算法;

public class 快速排序 {

    public static void main(String[] args) {
        int[] arr={4,1,6,8,2};
        quickSort(arr,0,arr.length-1);
        for (int i:arr){
            System.out.println(i);
        }
    }


    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int pirot = left;
            int index = left + 1;
            for (int i = index; i <= right; i++) {
                if (arr[i] < arr[pirot]) {
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                    index++;
                }
            }


            int temp = arr[pirot];
            arr[pirot] = arr[index - 1];
            arr[index - 1] = temp;

            int partition = index - 1;

            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);


        }
    }


}
