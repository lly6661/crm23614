package com.louis.sort;

import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/6/2 0002 21:35
 */
public class Msort {
    public static void main(String[] args) {
        int[] array = {31, 32, 1, 6, 9, 11, 24, 87, 37, 97, 108};

        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            /**
             * 求出中间值
             */
            int mid = (left + right) / 2;

            /**
             * 向左边分解
             */
            sort(array, left, mid, temp);

            /**
             * 向右边分解
             */
            sort(array, mid + 1, right, temp);


            /**
             * 合并数据
             */
            sum(array,left,right,mid,temp);
        }
    }

    public static void sum(int[] array,int left,int right,int mid,int[] temp){
        int i = left;
        int j = mid+1;

        /**
         * 指向临时数组下标
         */
        int t = 0;

        /**
         * 开始循环比较左右两边数组
         */
        while(i <= mid && j <= right){
            if(array[i] <= array[j]){
                temp[t] = array[i];
                i++;
                t++;
            }else{
                temp[t] = array[j];
                j++;
                t++;
            }
        }

        /**
         * 把剩余的数据全部存放临时数组中
         */
        while(i <= mid){
            temp[t] = array[i];
            i++;
            t++;
        }

        while(j <= right){
            temp[t] = array[j];
            j++;
            t++;
        }
        /**
         * 临时数组中的元素拷贝至原数组中
         */
        int tempIndex = left;
        int k = 0;
        while(tempIndex <= right){
            array[tempIndex] = temp[k];
            k++;
            tempIndex++;
        }

    }
}
