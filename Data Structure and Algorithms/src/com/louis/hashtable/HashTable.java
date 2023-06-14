package com.louis.hashtable;

/**
 * @Louis Restart
 * @date 2023/6/5 0005 22:18
 */
public class HashTable {
    private StudentLinkedList[] studentLinkedList;
    private int size;

    public HashTable() {
    }

    public HashTable(int size) {
        this.size = size;
        this.studentLinkedList = new StudentLinkedList[this.size];
        /**
         * 数组中添加链表对象
         */
        for (int i = 0; i < size; i++) {
            studentLinkedList[i] = new StudentLinkedList();
        }

    }

    /**
     * 哈希函数
     * @param sid
     * @return
     */
    public int hashCodes(int sid){
        return sid % size;
    }

    //添加学生
    public void add(Student student){
        //决定了是数组中的下标
        int hashVal = hashCodes(student.id);

        /**
         * 添加到指定链表中
         */
        studentLinkedList[hashVal].add(student);

    }

    /**
     * 查看哈希表中的元素
     */
    public void list(){
        for(int i = 0;i < size;i++){
            studentLinkedList[i].list(i);
        }
    }

    /**
     * 根据学生编号查询
     */
    public void findByStudentId(int sid){
        int hashVal = hashCodes(sid);
        Student student = studentLinkedList[hashVal].findById(sid);
        if (student!=null) {
            System.out.println("在第" + (hashVal + 1) + "链表中找到了学员，学员编号是" + sid);
        }else{
            System.out.println("抱歉，整个哈希表中未找到学员");
        }
    }
}
