package com.study.leetcode.递归回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 *
 */
public class 无重复字符串的排列组合 {

    public static void main(String[] args) {

        无重复字符串的排列组合 main = new 无重复字符串的排列组合();

        String S="qwe";
        String[] arr=main.permutation(S);

        for (String s:arr){
            System.out.println(s);
        }
    }

    public String[] permutation(String S) {

        ArrayList<String> res = new ArrayList<>();

        ArrayDeque<Character> path = new ArrayDeque<>();


        char[] nums = S.toCharArray();
        int len=nums.length;

        boolean[] used = new boolean[len];


        dfs(nums,0,len,path,res,used);

        return res.toArray(new String[0]);

    }

    private void dfs(char[] nums, int depth, int len, ArrayDeque<Character> path, ArrayList<String> res, boolean[] used) {

        if (depth==len) {


            ArrayList<Character> characters = new ArrayList<>(path);


            StringBuilder s= new StringBuilder();
            for (char a:characters){
                s.append(a);
            }
            res.add(s.toString());
            return;
        }

        for (int i=0;i<len;i++){

            if (used[i]) continue;

            path.addLast(nums[i]);

            used[i]=true;

            dfs(nums,depth+1,len,path,res,used);

            path.removeLast();

            used[i]=false;

        }

    }


}
