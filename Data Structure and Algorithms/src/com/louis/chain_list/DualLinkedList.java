package com.louis.chain_list;

/**
 * @Louis Restart
 * @date 2023/5/20 0020 20:29
 */
public class DualLinkedList {
    private BookNode head = new BookNode(0,"",0.0);

    /**
     * 添加结尾新的节点
     * @param bookNode
     */
    public void addLast(BookNode bookNode){
        BookNode temp = head;
        while(true){
            //表示已经是最后一个节点了
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        /**
         * 需要把新的节点给上一个节点的next
         * 需要把上一个节点给下一个节点的pre
         */
        temp.next = bookNode;
        bookNode.pre = temp;
    }

    /**
     * 修改节点
     * 条件：双向链表中，每一个节点的id和修改的id对比，如果对比成功，则修改该节点
     * 如果没有对比成功，则双向链表中未找到目标节点
     */
    public void updateNode(BookNode bookNode){
        //是否是空链表
        if(head.next == null){
            System.out.println("当前链表为空链表");
            return;
        }

        BookNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null) break;
            if(temp.id == bookNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = bookNode.name;
            temp.price = bookNode.price;
        }else{
            System.out.println("未找到要修改的节点");
        }
    }

    /**
     * 双向链表中根据ID删除
     */
    public void delNode(int id){
        if(head.next == null){
            System.out.println("空链表");
            return;
        }
        BookNode temp = head.next;
        boolean flag = false;
         while(true){
             if(temp == null){
                 break;
             }
             if(temp.id == id){
                 flag = true;
                 break;
             }
             temp = temp.next;
         }
         if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
         }else{
             System.out.println("未找到该节点");
         }
    }


}
