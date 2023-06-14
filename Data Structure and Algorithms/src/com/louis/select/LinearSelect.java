package com.louis.select;

/**
 * @Louis Restart
 * @date 2023/6/3 0003 21:22
 */
public class LinearSelect {
    public static void main(String[] args) {

        /**
         * 查询是否存在9这个元素，如果存在则返回索引值，否则返回-1
         */
        int[] array = {34, 21, 53, 55, 21, 32, 33, 9, 16, 26, 21, 7};
        System.out.println(select(array, 33));
    }

    public static int select(int[] array, int target) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
            return -1;
    }
}
