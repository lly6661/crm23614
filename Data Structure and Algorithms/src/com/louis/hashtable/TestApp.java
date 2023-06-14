package com.louis.hashtable;

import org.junit.Test;

/**
 * @Louis Restart
 * @date 2023/6/7 0007 21:48
 */
public class TestApp {
    @Test
    public void testHashTale(){
        HashTable hashTable = new HashTable(10);

        /**
         * 添加学生节点
         */
        Student s1 = new Student(1, "梁路易");
        Student s2 = new Student(2, "文皓清");
        Student s3 = new Student(3, "林晓青");
        Student s4 = new Student(4, "唐林燕");
        Student s5 = new Student(5, "芷珊");
        Student s6 = new Student(4, "小光");
        hashTable.add(s1);
        hashTable.add(s2);
        hashTable.add(s3);
        hashTable.add(s4);
        hashTable.add(s5);
        hashTable.add(s6);

        hashTable.list();

        hashTable.findByStudentId(4);
    }
}
