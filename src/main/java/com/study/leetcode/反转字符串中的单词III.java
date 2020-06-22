package com.study.leetcode;

import java.util.stream.IntStream;

/**
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */

public class 反转字符串中的单词III {

    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        reverseWords(s);

    }
    public static String reverseWords(String s) {

        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}
