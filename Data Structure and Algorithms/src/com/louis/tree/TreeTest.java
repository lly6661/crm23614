package com.louis.tree;

import org.junit.Test;

/**
 * @Louis Restart
 * @date 2023/6/8 0008 21:38
 */
public class TreeTest {
    @Test
    public void testTree() {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "卡卡罗特");
        Node node2 = new Node(2, "贝吉塔");
        Node node3 = new Node(3, "孙悟饭");
        Node node4 = new Node(4, "特南克斯");
        Node node5 = new Node(5, "界王");
        Node node6 = new Node(6, "克林");
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        //root.delNode(5);
        binaryTree.preSelect();
        //System.out.println("======================================================================");
        //binaryTree.infixSelect();
        //System.out.println("======================================================================");
        //binaryTree.postSelect();
        //System.out.println("======================================================================");

        Node node = binaryTree.preNode(4);
        if(node != null){
            System.out.println("查到辣!! id:" + node.getNo() + "  name：" + node.getName());
        }

    }
}
