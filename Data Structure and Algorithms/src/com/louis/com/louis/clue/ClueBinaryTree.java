package com.louis.com.louis.clue;

/**
 * 线索二叉树
 * @Louis Restart
 * @date 2023/6/12 0012 18:56
 */
public class ClueBinaryTree {
    //根节点
    private HeroNode root;

    //当前节点前驱节点指针
    private HeroNode pre;

    //当前节点后继节点指针
    private HeroNode post;


    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 调用这个方法，相当于把非线索化二叉树转线索化二叉树
     */
    public void clueNode(){
        this.clueNode(root);
    }



    /**
     * 把普通二叉树转线索化二叉树
     */
    public void clueNode(HeroNode node){
        //是否可以线索化当前节点
        if(node == null){
            return;
        }
        //先线索化左子树
        clueNode(node.getLeft());

        //处理当前节点的前驱
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setNoLeft(1);
        }

        //处理上个节点的后继
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setNoRight(1);
        }
        //保证处理完一个节点后，就需要让当前节点作为下一个节点的前驱
        pre = node;

        clueNode(node.getRight());
    }
    /**
     * 遍历线索化二叉树
     */
    public void clueList(){
        //临时节点
        HeroNode node = root;
        while(node != null){
            /**
             * 向左查找头结点
             */
            while(node.getNoLeft() == 0){
                node = node.getLeft();
            }
            System.out.println(node);

            while(node.getNoRight()  == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}
