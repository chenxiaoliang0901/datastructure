package com.study.datastructure.sparsearrray;


public class SparseArr {


    public static void main(String[] args) {

        //初始化二维数组大小，11x11
        int[][] chressArr = new int[11][11];

        //1:黑棋，2：白棋
        chressArr[1][2] = 2;
        chressArr[2][3] = 1;

        //原始二维数组如下所示：
        System.out.println("原始二维数组如下所示:\n");
        for (int[] row : chressArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //二维数组转稀疏数组
        //遍历数组，获取有效数值个数
        int count = 0;
        for (int row[] : chressArr) {
            for (int i : row) {
                if (i > 0) count++;
            }

        }
        //创建稀疏数组，行：count+1，列：3
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;

        //遍历二维数组，将有效的数据放进稀疏数组
        int m=0; //用于记录第几个有效值
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chressArr[i][j] > 0) {
                    m++;
                    sparseArray[m][0]=i;
                    sparseArray[m][1]=j;
                    sparseArray[m][2] = chressArr[i][j];

                }
            }
        }
        System.out.println("稀疏数组如下:\n");
        //打印稀疏数组
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
