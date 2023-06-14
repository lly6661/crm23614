package com.louis.chain_list;

/**
 * 节点类
 * @Louis Restart
 * @date 2023/5/17 0017 10:17
 */
public class GoodsNode {
    public int gId;
    public String gName;
    public double gPrice;

    //指针指向下一个节点
    public GoodsNode next;

    public GoodsNode(int gId, String gName, double gPrice) {
        this.gId = gId;
        this.gName = gName;
        this.gPrice = gPrice;
    }

    @Override
    public String toString() {
        return "GoodsNode{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                '}';
    }
}
