package com.study.leetcode;

import java.util.HashSet;

public class 最长连续序列 {

    public static void main(String[] args) {
            int[] nums={1,100,2,4,3,101};
        System.out.println(longestConsecutive(nums));
    }

    static int maxLength=0;
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int num:nums){
            hashSet.add(num);
        }

        for (int num:nums){
            if (!hashSet.contains(num-1)){
                int curNum=num;
                int curLength=1;

                while (hashSet.contains(curNum+1)){
                    curNum=curNum+1;
                    curLength++;
                }
                maxLength=Math.max(maxLength,curLength);
            }
        }
        return maxLength;
    }

}
