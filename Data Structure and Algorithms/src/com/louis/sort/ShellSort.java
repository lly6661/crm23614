package com.louis.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/6/2 0002 20:42
 */
public class ShellSort {
    @Test
    public void testShell(){
        int[] array = {31,32,1,6,9,11,24,87,37,97,108};
        /**
         * 实现增量变化
         * gap是初始znegliang
         */
        for(int gap = array.length/2;gap>0;gap/=2){
            //i理解为下标是从增量开始的
            for (int i = gap; i < array.length; i++) {
                //j理解为i-增量，那么j>>---增量---->>i
                //那么i和j就是一组元素
                //
                for(int j = i - gap;j >= 0;j -= gap){
                    if(array[j] > array[i]){
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
