package com.louis.select;

/**
 * @Louis Restart
 * @date 2023/6/3 0003 21:43
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {7, 17, 21, 34, 53, 55, 87};
        int target = 53;
        System.out.println(search(array, target));
    }
    public static int search(int[] array,int target){
        //最小索引指针
        int min = 0;
        //最大索引指针
        int max = array.length - 1;

        while (min <= max) {
            //算出平均索引的位置
            int mid = (min + max) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                min = mid + 1;
            }
            if (array[mid] > target) {
                max = mid - 1;
            }
        }
        return -1;
    }
}
