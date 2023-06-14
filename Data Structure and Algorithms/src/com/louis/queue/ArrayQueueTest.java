package com.louis.queue;
import org.junit.Test;

/**
 * @Louis Restart
 * @date 2023/5/26 0026 22:09
 */
public class ArrayQueueTest {
    @Test
    public void testQueue(){
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);


        int i = arrayQueue.get();
        System.out.println(i);
    }
}
