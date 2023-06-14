package com.louis.hashtable;

/**
 * @Louis Restart
 * @date 2023/6/5 0005 22:01
 */
public class Student {
    public int id;
    public String name;
    public Student next;

    public Student(int id, String name, Student next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }
}
