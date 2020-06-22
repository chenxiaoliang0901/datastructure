package com.study.leetcode;

/**
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 */

public class IP地址无效化 {

    public static void main(String[] args) {
        String address="13.13.1.3";


    }

    public String defangIPaddr(String address) {

        return address.replace(".","[.]");
    }
}
