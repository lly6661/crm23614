package com.louis.com.louis.clue;

/**
 * @Louis Restart
 * @date 2023/6/11 0011 22:07
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    /**
     * 如果是0，表示指向的是左子树 1表示指向前驱节点
     */
    private int noLeft;


    /**
     * 如果是0表示指向右子树 1表示指向后继节点
     */
    private int noRight;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getNoLeft() {
        return noLeft;
    }

    public void setNoLeft(int noLeft) {
        this.noLeft = noLeft;
    }

    public int getNoRight() {
        return noRight;
    }

    public void setNoRight(int noRight) {
        this.noRight = noRight;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 删除节点
     * 删除的可能是一个叶子结点，也可能是一个非叶子节点
     */
    public void delNode(int no){
        /**
         * 如果当前节点的左节点不为空，并且左节点正好是要删除的 this.left=null
         * 如果当前节点的右节点不为空，并且右节点正好是要删除的 this.right=null
         * 如果上两步都没有执行，左子树递归
         * 上述都没执行，右子树递归
         */
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        /**
         * 判断，防止异常
         */
        if(this.left != null){
        this.left.delNode(no);
        }

        if(this.right != null){
            this.right.delNode(no);
        }
    }
    /**
     * 前序遍历所有的
     */
    public void preSelect(){
        System.out.println(this);
        if(this.left != null){
            this.left.preSelect();
        }

        if(this.right != null){
            this.right.preSelect();
        }
    }

    /**
     *根据编号前序查找
     */
    public HeroNode preSelect(int no){
        if(this.no == no){
            return this;
        }

        HeroNode temp = null;
        //往左递归
        if(this.left != null){
            temp = this.left.preSelect(no);
        }
        if(temp != null){
            return temp;
        }

        if(this.right != null){
            temp = this.right.preSelect(no);
        }
        return temp;
    }
}
