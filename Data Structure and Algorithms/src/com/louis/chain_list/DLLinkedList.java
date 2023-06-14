package com.louis.chain_list;

/**
 * 列表
 *
 * @Louis Restart
 * @date 2023/5/17 0017 10:19
 */
public class DLLinkedList {
    //头部节点
    private GoodsNode node = new GoodsNode(0, "", 0);

    /**
     * 往链表中添加节点
     *
     * @param goodsNode
     */
    public void add(GoodsNode goodsNode) {
        //这个temp就相当于一个指针，一开始指向头结点，
        //然后while循环找到尾节点后break，再在尾节点后插入数据
        GoodsNode temp = node;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //一直往下找，直到最后一个节点
            temp = temp.next;
        }
        temp.next = goodsNode;
    }

    /**
     * 插入结点按照商品编号id值插入，从小到大的顺序
     */
    public void addByOrder(GoodsNode goodsNode) {
        GoodsNode temp = node;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //当前节点的ID值大于新进来节点的id例如4大于3，那么3就要插到前面去
            if (temp.next.gId > goodsNode.gId) {
                break;
            } else if (temp.next.gId == goodsNode.gId) {//说明已经插入过了去重，不允许插入ID值一样的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("不能添加该商品，已经存在了");
        } else {
            //这时候的Temp.next指向的就是4，所以把4赋值给3的next，没问题
            goodsNode.next = temp.next;
            //再把3赋值给2的next
            temp.next = goodsNode;
        }
    }

    /**
     * 修改节点
     * 1.先找到链表中的目标节点
     * 2.根据新的数据修改
     * 3.根据商品的ID进行寻找，因为商品的ID是不允许重复的
     */

    public void updateNode(GoodsNode goodsNode) {
        /**
         * 如果链表是空的
         */
        if (node.next == null) {
            System.out.println("链表为空");
            return;
        }

        GoodsNode temp = node.next;
        //什么时候会结束循环
        //1.找到最后一个也没找到
        //2.找到修改的节点

        //标识符 表示找到了节点
        boolean flag = false;
        while (true) {
            if (temp == null) break;
            if (temp.gId == goodsNode.gId) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //不能整个节点换掉，因为temp储存的节点中可能会有下一个节点next属性
            //直接把节点替换掉可能链表后面的部分就消失了
            //为了数据的安全，所以只能更改属性
            temp.gName = goodsNode.gName;
            temp.gPrice = goodsNode.gPrice;
        }
    }

    /**
     * 节点删除功能
     * 条件：根据节点的编号删除
     */

    public void delNode(int id) {

        GoodsNode temp = node;

        boolean flag = false;
        while (true) {
            if (temp.next == null) break;

            if (temp.next.gId == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("未找到删除的节点");
        }
    }

    /**
     * 定义查看链表中的每一个节点元素
     */
    public void list() {
        if (node.next == null) {
            System.out.println("空链表");
            return;
        }

        GoodsNode temp = node.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 面试题
     * 计算单链表中存在的节点个数
     * 不统计头结点
     */

    public int getLength() {
        if (node.next == null) {
            System.out.println("空链表");
            return 0;
        }
        GoodsNode temp = node.next;

        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }


}
