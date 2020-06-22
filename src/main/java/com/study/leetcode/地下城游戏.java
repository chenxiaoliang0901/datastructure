package com.study.leetcode;

/**
 * -2 (K) 	-3 	3
 * -5 	-10 	1
 * 10 	30 	-5 (P)
 */
public class 地下城游戏 {
    static int rowSize = 0;
    static int colSize = 0;

    public static void main(String[] args) {
        int[][] array = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        System.out.println("迷宫地图为：");
        for (int row[] : array) {
            for (int i : row) {
                System.out.printf("%s\t", i);
            }
            System.out.println("");
        }
        rowSize = array.length;
        colSize = array[0].length;
        System.out.println("----------------------");
        //递归优化，去除重复值
        int[][] memory = new int[rowSize][colSize];
        // 初始化为-1。
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                memory[i][j] = -1;
            }
        }
        int res = dnf(array, memory, 0, 0) + 1;
        System.out.println("骑士的最小初始值为：" + res);


    }


    public static int dnf(int[][] array, int[][] memory, int rowIndex, int colIndex) {

        if (rowIndex >= rowSize || colIndex >= colSize) {
            return Integer.MAX_VALUE;
        }
        //如果值已经存在，那么直接返回该值
        if (memory[rowIndex][colIndex] != -1) {

            return memory[rowIndex][colIndex];
        }
        //退出条件
        if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
            if (array[rowIndex][colIndex] >= 0) {
                // 如果最后一个大于等于0，就返还0。
                return 0;
            } else {
                //如果最后一个小于零，就返回负的值。
                return -array[rowIndex][colIndex];
            }
        }

        //求右边最优解
        int right = dnf(array, memory, rowIndex, colIndex + 1);
        //求下边最优解
        int down = dnf(array, memory, rowIndex + 1, colIndex);

        //求出骑士最小初始值(f(i,j) = min(f(i,j+1),f(i+1,j)) - array[i][j])
        int needMin = Math.min(right, down) - array[rowIndex][colIndex];

        //不允许骑士的血量小于零
        int res;
        if (needMin < 0) {
            res = 0;
        } else {
            res = needMin;
        }
        memory[rowIndex][colIndex] = res;

        System.out.printf("row:%d\tcol:%d\tres:%d", rowIndex, colIndex, res);
        System.out.println();
        return res;

    }

}
