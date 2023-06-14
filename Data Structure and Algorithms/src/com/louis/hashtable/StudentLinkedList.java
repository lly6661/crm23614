package com.louis.hashtable;

/**
 * @Louis Restart
 * @date 2023/6/5 0005 22:02
 */
public class StudentLinkedList {
    private Student head;
    /**
     * 添加节点
     * 如果添加时是第一个学生对象
     */
    public void add(Student newStudent){
        //如果添加的是第一个学生对象，则直接复制给第一个节点
        if(head == null){
            head = newStudent;
            return;
        }
        Student temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            //继续往后查找
            temp = temp.next;
        }
        //追加了新的节点
        temp.next = newStudent;
    }

    public void list(int no){
        if(head == null){
            System.out.println("第" + no + "个链表没有元素");
            return;
        }
        Student temp = head;
        while(true){
            System.out.print("id=" + temp.id + ",name=" + temp.name + "  ");
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 根据学院编号查询节点 id
     */
    public Student findById(int id){
        if(head == null){
            System.out.println("这是个空链表");
            return null;
        }
        Student temp = head;
        while(true){
            if(temp.id == id){
                break;
            }
            if(temp.next == null){
                System.out.println("找不到对应学生");
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

}
