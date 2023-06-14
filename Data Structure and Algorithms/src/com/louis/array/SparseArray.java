package com.louis.array;

/**
 * @Louis Restart
 * @date 2023/5/23 0023 22:20
 */
public class SparseArray {
    public static void main(String[] args) {
        /**
         * 模拟出来棋盘数据，使用二维数组
         */
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][4] = 2;
        //计算数组中非0的元素
        int validCount = 0;
        //打印棋盘 查看效果
        for(int[] row:array){
            for(int var :row){
                if(var != 0) validCount++;
                System.out.print(var + "\t");
            }
            System.out.println();
        }

        /**
         * 将二维数组压缩至稀疏数组
         */
        int[][] sparseArray = new int[validCount + 1][3];
        //给稀疏数组的第一行赋值
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = validCount;

        //把有效数据存放至稀疏数组中
        int temp = 1; //指针
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                //判断是否是有效数据
                if(array[i][j] != 0){
                    sparseArray[temp][0] = i;
                    sparseArray[temp][1] = j;
                    sparseArray[temp][2] = array[i][j];
                    temp++;
                }
            }
        }
        /**
         * 打印稀疏数组
         */
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j] + "\t");
            }
            System.out.println();
        }

        /**
         * 稀疏数组转二维数组
         */
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];
        validCount = sparseArray[0][2];
        int[][] oriArray = new int[row][column];
        for (int i = 1; i < validCount + 1; i++) {
            oriArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("-------------------------------------->");
        /**
         * 查看原始二维数组棋盘
         */
        for (int i = 0; i < oriArray.length; i++) {
            for (int j = 0; j < oriArray[i].length; j++) {
                System.out.print(oriArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
