package com.study.leetcode.递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *
 */

public class 括号生成 {

    public static void main(String[] args) {
        int n=3;

        括号生成 a=new 括号生成();

        List<String> list=a.generateParenthesis(n);

        for (String s:list){
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        if(n<0) return null;

        ArrayList<String> res = new ArrayList<>();

        dfs("",n,n,res);
        return res;

    }

    private void dfs(String s, int left, int right, ArrayList<String> res) {
        if(left==0&&right==0) {
            //因为每一次尝试，都使用新的字符串变量，所以无需回溯
            res.add(s);
            return;
        }
        if (left>right) return;

        if(left>0) dfs(s+"(",left-1,right,res);
        if(right>0) dfs(s+")",left,right-1,res);

    }


}
