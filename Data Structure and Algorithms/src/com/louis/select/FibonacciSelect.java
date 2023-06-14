package com.louis.select;

import java.util.Arrays;

/**
 * @Louis Restart
 * @date 2023/6/4 0004 21:30
 */
public class FibonacciSelect {
    public static void main(String[] args) {
        int[] array = {7, 17, 21, 34, 53, 55, 87, 97};
        System.out.println(fibSearch(array,9));
    }

    //因为mid=low+F(k-1)-1
    //mid可以理解为一个分割后的黄金分割点
    //通过这个mid不断地循环或者递归，找到最后的值
    //F就是斐波那契数组，先创建一个斐波那契数组
    //1,1,2,3,5,8,13,21,34,55
    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找算法

    /**
     * @param array 数组
     * @param key   需要查找的值
     * @return 返回对应的下标，如果没有就返回-1
     */
    public static int fibSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        //获取斐波那契数列
        int f[] = fib();
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]值可能大于array数组的长度，因此我们需要使用一个Arrays类构造一个新的数组
        //并指向temp
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(array, f[k]);
        //实际上，需要使用a数组最后的数填充temp
        //举例：
        //temp{7, 17, 21, 34, 53, 55, 87,97,97,97,97,97,97}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = array[high];
        }
        //使用while来循环处理，找到我们的key
        while (low <= high) { //只要这个条件满足就可以一直循环
            mid = low + f[k - 1] - 1;
            //说明key在分割点前面，需要把high指向mid
            if(key < temp[mid]){
                high = mid - 1;
                //为什么是k--
                //说明
                //1.全面的元素 = 前面的元素 + 后面的元素 被黄金分割点分割开了
                //2.f[k] = f[k - 1] + f[k - 2]
                //3.因为前面有f[k - 1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                //4.即在f[k-1]的前面继续分割查找k--
                //5.即下次循环mid = f[k-1-1]-1
                k--;
            }else if(key > temp[mid]){
                //此条件成立，说明key在分割点后面，需要把low指向mid
                //后面有f[k-2]个元素了，需要继续拆分
                //f[k-2] = f[k-3] + f[k-4]
                low = mid + 1;
                k -= 2;
            }else{
                //找到
                //需要确定返回的是哪个下标
                if(mid <= high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
