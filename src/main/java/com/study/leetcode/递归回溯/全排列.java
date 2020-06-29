package com.study.leetcode.递归回溯;

import java.util.*;

/**
 * 回溯框架
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 */

public class 全排列 {

    private List<List<Integer>> permute(int[] nums) {

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();

        boolean[] used = new boolean[len];

        dfs(nums, len, 0, path, used, res);

        return res;


    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;

        }

        for (int i = 0; i < len; i++) {
            if (used[i]) continue;

            path.addLast(nums[i]);

            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);
            //撤销选择
            path.removeLast();

            used[i] = false;
        }

    }
}
