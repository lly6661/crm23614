package com.louis.select;

/**
 * @Louis Restart
 * @date 2023/6/4 0004 21:06
 */
public class InsertSelect {
    public static void main(String[] args) {
        int[] array = {7, 17, 21, 34, 53, 55, 87};

        int l = 0;
        int r = array.length -1;
        System.out.println(select(array, l, r,36));

    }

    public static int select(int[] array,int left,int right,int searchVal){
        /**
         * 防止数组越界
         */
        if(left>right || searchVal<array[0] || searchVal > array[array.length-1]){
            return -1;
        }
        int mid = left + (right-left)*(searchVal-array[left])/(array[right]-array[left]);
        int midValue = array[mid];
        if(searchVal > midValue){
             return select(array,mid + 1,right,searchVal);
        }else if(searchVal < midValue){
            return select(array,left,mid - 1,searchVal);
        }else{
            return mid;
        }
    }
}
