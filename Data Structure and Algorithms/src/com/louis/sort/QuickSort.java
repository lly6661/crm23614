package com.louis.sort;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/5/31 0031 21:27
 */
public class QuickSort {
    @Test
    public void testQuick(){
        int[] array = {31,32,1,6,9,11,24,87,37,97,108};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array,int left,int right){
        int l = left;
        int r = right;
        int pivot = array[(left+right)/2];
        int temp = 0;
        while(l < r){
            while(array[r] > pivot){
                r--;
            }
            while(array[l] < pivot){
                l++;
            }
            if(l >= r){
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if(array[r] == pivot){
                l++;
            }
            if(array[l] == pivot){
                r--;
            }
            if(l == r){
                l++;
                r--;
            }
            if(left < r){
                sort(array,left,r);
            }
            if(right > l){
                sort(array,l,right);
            }

        }
    }
}
