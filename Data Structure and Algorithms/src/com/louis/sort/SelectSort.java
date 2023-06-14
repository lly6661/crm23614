package com.louis.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/6/1 0001 21:55
 */
public class SelectSort {
    @Test
    public void testSelect(){
        int[] array = {31,32,1,6,9,11,24,87,37,97,108};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("排序完后的顺序");
        System.out.println(Arrays.toString(array));
    }
}
