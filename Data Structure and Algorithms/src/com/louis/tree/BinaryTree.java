package com.louis.tree;

/**
 * @Louis Restart
 * @date 2023/6/8 0008 21:35
 */
public class BinaryTree {
    private Node root;
    public void setRoot(Node node){
        this.root = node;
    }
    /**
     *
     */
    public void preSelect(){
        if(this.root != null){
            this.root.preSelect();
        }else{
            System.out.println("空二叉树，无法遍历...");
        }
    }
    public void infixSelect(){
        if(this.root != null){
            this.root.infixSelect();
        }else{
            System.out.println("空二叉树，无法遍历...");
        }
    }

    public void postSelect(){
        if(this.root != null){
            this.root.postSelect();
        }else{
            System.out.println("空二叉树，无法遍历...");
        }
    }

    /**
     * 根据节点编号的前序查询
     */
    public Node preNode(int no){
        if(root != null){
           return root.preSearch(no);
        }
        System.out.println("空二叉树，无法遍历...");
        return null;
    }

    /**
     * 根据节点编号的中序查询
     */
    public Node infixNode(int no){
        if(root != null){
            return root.infixSearch(no);
        }
        System.out.println("空二叉树，无法遍历...");
        return null;
    }

    /**
     * 根据节点编号的后序查询
     */
    public Node postNode(int no){
        if(root != null){
            return root.postSearch(no);
        }
        System.out.println("空二叉树，无法遍历...");
        return null;
    }

    /**
     * 删除节点
     */
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("空二叉树，无法删除...");
        }
    }


}
