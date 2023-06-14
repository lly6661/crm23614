package com.louis.queue;

/**
 *数组实现队列
 * @Louis Restart
 * @date 2023/5/25 0025 21:24
 */
public class ArrayQueue {
    private int[] array;
    private int maxSize;
    private int frontPoint;
    private int rearPoint;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.array = new int[maxSize];

        frontPoint = -1;
        rearPoint = -1;
    }

    /**
     * 判断当前队列是否已满
     * 这种写法不规范，会导致假溢出现象
     */
    public boolean isFull(){
        //不能真的存满，需要留一个位置managed
        return rearPoint == maxSize - 1;
    }

    /**
     * 判断是否是空队列
     */
    public boolean isEmpty(){
        return frontPoint == rearPoint;
    }

    /**
     * 添加元素进入队列
     * 这里不准确rearPoint应该指向队尾的下一个元素
     * 且由于这里定义的rearPoint是从-1开始的，所以需要
     * 先判断是否是空队列，要是空了就先自增，然后赋值后再自增
     * 使得rearPoint指向队尾的下一位
     */
    public void add(int n){
        //判断是否已满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        if(isEmpty()){
            rearPoint++;
        }
        array[rearPoint] = n;
        rearPoint++; //这时候，rear指针指向的就是队尾的后一位元素
    }

    /**
     * 获取队列元素并且删除元素，出队列
     * 有疑问，可能有错误的
     * 这里队头出队了，但是实际上元素还在数组里面，没有删除
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        frontPoint++;
        return array[frontPoint];
    }

    /**
     * 查看队列中的元素
     * 有疑问，可能有错误的
     * 这里大错特错，因为查看的是数组中的元素
     * 按照上面入队的操作，应该从front 到 rear指针遍历，而不应该遍历整个数组
     * 否则会把之前出队的也遍历了
     */
    public void findQueue(){
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("第" + i + "个元素是：" + array[i]);
        }
    }

    /**
     * 查看队头元素，不是出队列
     */
    public int frontQueue(){
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        return array[frontPoint];
    }

}
