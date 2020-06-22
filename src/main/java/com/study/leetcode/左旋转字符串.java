package com.study.leetcode;

/**
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class 左旋转字符串 {

    public static void main(String[] args) {
        String s="abcd";
        System.out.println(reverseLeftWords(s,2));
    }
    public static String reverseLeftWords(String s, int n) {
        String a=s.substring(0,n);
        String b=s.substring(n);
        return b+a;

    }
}
