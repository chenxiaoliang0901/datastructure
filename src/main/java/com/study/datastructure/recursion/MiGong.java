package com.study.datastructure.recursion;

public class MiGong {

    public static void main(String[] args) {
        //创建一个二维数组，表示迷宫
        int[][] map = new int[8][7];

        //上下用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右用1表示墙
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        //打印地图
        System.out.println("迷宫地图为：");
        for (int row[]:map){
            for (int i:row){
                System.out.printf("%s\t",i);
            }
            System.out.println();
        }

        System.out.println("小球行走路径为：");

        findWay(map,1,1);

        for (int row[]:map){
            for (int i:row){
                System.out.printf("%s\t",i);
            }
            System.out.println();
        }

    }
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定: 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ; 2 表示通路可以走 ; 3 表示该点已经走过，但是走不通
    /**
     *
     * @param map 迷宫的地图
     * @param i 小球开始的坐标
     * @param j
     * @return true表示周到出口，规定：小球的默认行走路线为 右->上->左->下
     *
     */
    public static boolean findWay(int[][] map,int i,int j){

        if(map[6][5]==2){
            return true;
        }
        if(map[i][j]==0){//说明当前路可以走
            //将该值暂时更改为2
            map[i][j]=2;
            if (findWay(map,i,j+1)){
                return true;
            }else if(findWay(map,i-1,j)){
                return true;
            }else if(findWay(map,i,j-1)){
                return true;
            }else if(findWay(map,i+1,j)){
                return true;
            }else {
                map[i][j]=3;
                return false;
            }
        }else {
            return false;
        }

    }
}
