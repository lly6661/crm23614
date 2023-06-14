package com.louis.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/6/1 0001 21:26
 */
public class InsertSort {
    @Test
    public void testInsert(){
        int[] array = {34,21,53,55,21,32,33,51,16,26,21,7};

        //控制去拿每一个元素
        for (int i = 1; i < array.length; i++) {
            //比较的次数，i等于几，就循环几次
            for(int j = i;j >= 1;j--){
                //是否小于前面的元素
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        System.out.println("排序后的结果：");
        System.out.println(Arrays.toString(array));
    }
}
