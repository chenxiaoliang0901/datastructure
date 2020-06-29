package com.study.leetcode.排序算法;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 算法步骤
 * <p>
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * <p>
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * <p>
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * <p>
 * 重复步骤 3 直到某一指针达到序列尾；
 * <p>
 * 将另一序列剩下的所有元素直接复制到合并序列尾。
 */
public class 归并排序 {

    public static void main(String[] args) {
        归并排序 a=new 归并排序();
        int[] sourceArray={4,6,2,7,1};

        int[] arr = a.mergeSort(sourceArray);
        for(int i:arr){
            System.out.println(i);
        }
    }

    public int[] mergeSort(int[] sourceArray) {

        if (sourceArray.length < 2) {
            return sourceArray;
        }

        int middle = (int) Math.floor(sourceArray.length / 2);

        int[] left = Arrays.copyOfRange(sourceArray, 0, middle);
        int[] right = Arrays.copyOfRange(sourceArray, middle, sourceArray.length);

        return merge(mergeSort(left), mergeSort(right));


    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];

        int index = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                res[index++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                res[index++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length>0){
            res[index++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);

        }
        while (right.length>0){
            res[index++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);

        }



        return res;
    }
}
