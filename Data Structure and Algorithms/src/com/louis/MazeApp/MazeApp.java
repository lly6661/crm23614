package com.louis.MazeApp;

import org.junit.Test;

/**
 * @Louis Restart
 * @date 2023/5/26 0026 22:35
 */
public class MazeApp {
    @Test
    public void testMaze() {
        int[][] map = new int[8][7];

        /**
         * 设置第一行和最后一行为墙
         */
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        /**
         * 设置第一列和第7列为墙
         */

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        /**
         * 给中间的两个位置设置为墙
         */
        map[3][1] = 1;
        map[3][2] = 1;

        /**
         * 展示
         */
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    System.out.print(" ■ ");
                } else if(map[i][j] == 0) {
                    System.out.print(" □ ");
                }
                //System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println("新的迷宫");

        isRun(map,1,1);

        System.out.println("小球走的路线");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    System.out.print(" ■ ");
                } else if(map[i][j] == 0) {
                    System.out.print(" □ ");
                }else{
                    System.out.print(" " + map[i][j] + " ");
                }

                //System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }



    /**
     * 小球从(1,1)坐标开始出发
     * 终点坐标是(6,5)
     * map是地图对象
     * 元素为0时表示为路，且没走过的
     * 元素为1时表示为墙
     * 元素2表示通过可以走
     * 元素3表示已经走过，但是走不通
     */
    public static boolean isRun(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //上次走到了终点
            return true;

        } else {
            if (map[i][j] == 0) {
                //没有走过
                map[i][j] = 2;

                //下 右 上 左
                if (isRun(map, i + 1, j)) {
                    return true;
                } else if (isRun(map, i, j + 1)) {
                    return true;
                } else if (isRun(map, i - 1, j)) {
                    return true;
                } else if (isRun(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
