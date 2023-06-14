package com.louis.chain_list;

/**
 * @Louis Restart
 * @date 2023/5/21 0021 19:35
 */
public class CircleSingleLinkedList {
    private Boy first = new Boy(-1);
    /**
     * 构建环形链表
     */
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("数据不正确");
        }
        Boy temp = null;
        for(int i = 1;i <= nums;i++){
            Boy boy = new Boy(i);
            /**
             * 判断你是否是第一个小孩
             */
            if(i == 1){
                first = boy;
                first.setNext(first);
                temp = first;
            }else{
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;

            }

            if(i == nums){
                temp.setNext(first);
            }
        }
    }

    /**
     * 查看环形链表中的节点
     */
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        Boy boy = first;
        while(true){
            System.out.println("小孩的编号是" + boy.getNo());

            //判断是否是最后一个元素
            if (boy.getNext() == first) {
                break;
            }
            boy = boy.getNext();
        }
    }

    /**
     * 当调用该方法输入第几个小孩开始数数，数几次，环形链表中一共几个小孩
     * @param startNo
     * @param countNum
     * @param nums
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo < 1 || startNo > nums || countNum > nums){
            System.out.println("参数输入有误");
        }
        /**
         * 定义辅助指针，指向的是环形单链表中的最后一个节点
         */
        Boy helper = first;
        while(true){
            if(helper.getNext() == first) break;
            helper = helper.getNext();
        }

        /**
         * 寻找起始位置 把first定义为新的起始位置
         */
        for(int j = 0;j < startNo -1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }

        /**
         * 当小孩进行报数是，数到m的孩子出列，让first和helper移动m-1次即可
         * 找到了出列的孩子
         */
        while(true){
            if(helper == first){
                break;
            }
            for(int j = 0;j < countNum -1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩" + first.getNo() + "出列");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后出圈的小孩编号" + first.getNo());
    }
}
