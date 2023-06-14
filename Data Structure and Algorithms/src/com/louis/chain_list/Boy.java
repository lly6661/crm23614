package com.louis.chain_list;

/**
 * @Louis Restart
 * @date 2023/5/21 0021 19:29
 */
public class Boy {
    private int no;
    private Boy next;

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy() {
    }

    public Boy(int no) {
        this.no = no;
    }
}
