package com.louis.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Louis Restart
 * @date 2023/5/28 0028 21:56
 */
public class BaseSort {

    @Test
    public void testBaseSort() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        System.out.println("开始：" + simpleDateFormat.format(new Date()));
        int[] array = {53, 542, 3, 63, 14, 214, 154, 747, 623, 963};
        sort(array);
        System.out.println("结束：" + simpleDateFormat.format(new Date()));
    }

    public static void sort(int[] array) {
        /**
         * 获取最大位数
         */
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])  max = array[i];
        }
        /**
         * 获取字符串长度，所以把int类型转字符串类型
         */
        int length = String.valueOf(max).length();
        System.out.println(length);

        /**
         * 定义二维数组，大小10，表示10个桶，每一个桶则是一个数组,代表数字0-9
         * [[],[],[],[],[],[],[]]
         */
        int[][] bucket = new int[10][array.length];

        /**
         * 辅助数组 用来记录哪个档位的桶子记录了多少条数据，便于存放和获取数据
         */
        int[] bucketElementCount = new int[10];

        /**
         * 循环获取无序数列的个位数即桶子的下标
         */
        for (int j = 0; j < array.length; j++) {
            int locationElement = array[j] % 10;

            /**
             * 放入桶中
             * bucketElementCount[locationElement]是辅助数组，保存个数的
             */
            bucket[locationElement][bucketElementCount[locationElement]] = array[j];
            //bucket存放数据后，辅助数组当前档位记录自增
            bucketElementCount[locationElement]++;
        }

        /**
         * 遍历每一个桶，将元素存放原数组中
         */
        int count = 0;
        //0-9
        for (int k = 0; k < bucketElementCount.length; k++) {
            //说明这个档位的桶存在数据
            if(bucketElementCount[k] != 0){
                //bucketElementCount[k]的值就是个数
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    //count就是原数组的下标，赋值后自增，bucket[k][l]就是数值
                   array[count++] = bucket[k][l];
                }
            }
            //将临时数组重置，准备下一次的循环
            bucketElementCount[k] = 0;
        }
        System.out.println(Arrays.toString(array));

        /**
         * 对十位数进行比较
         */
        for(int j = 0;j < array.length;j++){
            int locationElement =  array[j]/10%10;
            bucket[locationElement][bucketElementCount[locationElement]++] = array[j];
        }

        //取出来，按照原顺序放回桶里
        int index = 0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i] != 0){
                for (int j = 0; j < bucketElementCount[i];j++) {
                    array[index++] = bucket[i][j];
                }
            }
            bucketElementCount[i] = 0;
        }
        System.out.println("第二次遍历------------------------------------------------------------------->>");
        System.out.println(Arrays.toString(array));

        //对百位数进行比较

        for(int j = 0;j < array.length;j++){
            int locationElement =  array[j]/100;
            bucket[locationElement][bucketElementCount[locationElement]++] = array[j];
        }

        //取出来，按照原顺序放回桶里
        int index1 = 0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i] != 0){
                for (int j = 0; j < bucketElementCount[i];j++) {
                    array[index1++] = bucket[i][j];
                }
            }
            bucketElementCount[i] = 0;
        }
        System.out.println("第三次遍历------------------------------------------------------------------->>");
        System.out.println(Arrays.toString(array));
    }
}
