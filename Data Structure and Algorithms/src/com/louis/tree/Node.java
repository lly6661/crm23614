package com.louis.tree;

/**
 * @Louis Restart
 * @date 2023/6/8 0008 21:15
 */
public class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    /**
     * 定义前序遍历
     */
    public void preSelect(){
        //先输出父节点
        System.out.println(this);
        if(this.left != null){
            this.left.preSelect();
        }
        if(this.right != null){
            this.right.preSelect();
        }
    }

    /**
     * 定义中序遍历
     */
    public void infixSelect(){
        //左节点 父节点 右节点
        if(this.left != null){
            this.left.infixSelect();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixSelect();
        }
    }

    /**
     * 定义后续遍历
     */
    public void postSelect(){
        if(this.left != null){
            this.left.infixSelect();
        }
        if(this.right != null){
            this.right.infixSelect();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     */
    public Node preSearch(int no){
        //判断是否是当前节点
        if(this.no == no){
            return this;
        }
        //查询左子节点
        Node lNode = null;
        if(this.left != null){
            lNode = this.left.preSearch(no);
        }
        if(lNode != null){
            return lNode;
        }

        //查询当前节点的右子节点
        Node rNode = null;
        if(this.right != null){
            rNode = this.right.preSearch(no);
        }
        if(rNode != null){
            return rNode;
        }
        return null;
    }

    /**
     * 中序遍历查找
     */
    public Node infixSearch(int no){
        //查询左子节点
        Node lNode = null;
        if(this.left != null){
            lNode = this.left.infixSearch(no);
        }
        if(lNode != null){
            return lNode;
        }

        //判断是否是当前节点
        if(this.no == no){
            return this;
        }


        //查询当前节点的右子节点
        Node rNode = null;
        if(this.right != null){
            rNode = this.right.infixSearch(no);
        }
        if(rNode != null){
            return rNode;
        }
        return null;
    }

    /**
     * 后序遍历查找
     */
    public Node postSearch(int no){
        //查询左子节点
        Node lNode = null;
        if(this.left != null){
            lNode = this.left.postSearch(no);
        }

        //查询当前节点的右子节点
        Node rNode = null;
        if(this.right != null){
            rNode = this.right.postSearch(no);
        }
        if(rNode != null){
            return rNode;
        }

        if(lNode != null){
            return lNode;
        }

        //判断是否是当前节点
        if(this.no == no){
            return this;
        }
        return null;
    }

    /**
     * 删除节点两种情况
     * 1.删除的结点是叶子结点
     * 2.删除的结点是子树，非叶子结点
     */
    public void delNode(int no){
        /**
         * 1、当前节点的左节点不为空，并且左节点就是要删除的结点 this.left = null
         * 2、当前节点的右节点不为空，并且右节点就是要删除的结点 this.right = null
         * 3、如果第一步和第二步没有执行，那么需要向左子树进行递归删除
         * 4、如果第三步没有执行，那么需要像右子树进行递归删除
         */
        if(this.left != null && this.left.no == no){
            this.left = null;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;

        }
        /**
         * 向左子树进行递归删除
         */
        if(this.left != null){
            this.left.delNode(no);
        }

        /**
         * 向右子树进行递归删除
         */
        if(this.right != null){
            this.right.delNode(no);
        }
    }

}
