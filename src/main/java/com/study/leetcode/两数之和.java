package com.study.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */

public class 两数之和 {
    public static void main(String[] args) {
        int[] arr={1,3,2,8,5,4,7};
        int target= 10;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){

            map.put(arr[i], i);

            int key=target-arr[i];
            if(map.containsKey(key)){
                System.out.printf("%d\t%d\n",key,arr[i]);
            }


        }

    }


}
