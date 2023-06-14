package com.louis.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/5/30 0030 22:29
 */
public class BubblingSort {
    @Test
    public void testBubbling(){
        int[] array = {43,62,42,23,1,7,25,56,17,88};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if(array[j] > array[j + 1]){
                    int t = 0;
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
