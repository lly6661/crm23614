package com.louis.chain_list;

import java.awt.print.Book;

/**
 * @Louis Restart
 * @date 2023/5/20 0020 20:26
 */
public class BookNode {
    public int id;
    public String name;
    public double price;

    //下一个节点 直接后继
    public BookNode next;

    //上一个节点 直接前驱
    public BookNode pre;

    public BookNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
