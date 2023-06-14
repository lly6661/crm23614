package com.louis.stack;

import java.lang.reflect.Array;

/**
 * @Louis Restart
 * @date 2023/5/13 0013 20:32
 */
public class ArrayStack {
    //栈的大小
    private int maxStack;

    //数组用来模拟栈
    private int[] stack;

    //表示栈顶所在的位置，默认情况下如果没有数据时，使用-1
    private int top = -1;

    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        this.stack = new int[this.maxStack];
    }

    /**
     * 1.压栈
     * 2.弹栈
     * 3.判断是否是空栈
     * 4.当前栈中是否是满栈
     */

    //判断是否已经满栈
    public boolean isFull() {
        return this.top == maxStack - 1;
    }

    //判断是否是空栈
    public boolean isEmpty() {
        return this.top == -1;
    }

    //压栈
    public void push(int val) {
        //先判断是否满栈了
        if (isFull()) {
            throw new RuntimeException("此栈已满");
        }

        //top指向的是原来，需要向上移动一位
        this.top++;
        //栈中存放数据 压栈
        stack[top] = val;
    }

    //弹栈
    public int pop() {
        //判断栈是否是空的
        if (isEmpty()) {
            throw new RuntimeException("空栈，未找到数据");
        }
        int value = stack[top];
        stack[top] = 0;
        top--;
        return value;
    }

    //查看栈中所有元素

    public void list() {
        //是否是空栈
        if (isEmpty()) {
            throw new RuntimeException("空栈，未找到数据");
        }
        for (int i = 0; i < this.stack.length; i++) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

    //查看栈中元素的个数
    public int length() {
        return this.top + 1;
    }

    /**
     * 判断是否是一个运算符，只针对+ - * /
     */
    public boolean isOperator(char v) {
        return v == '+' || v == '-' || v == '/' || v == '*';
    }

    /**
     * 判断运算符优先级 使用数字来表示优先级的大小
     * 数字越大，优先级越大
     *
     * @return
     */
    public int priority(int v) {
        if (v == '+' || v == '-') {
            return 0;
        } else if (v == '/' || v == '*') {
            return 1;
        } else {
            return -1;
        }
    }

    //查看栈顶数据
    public int peak() {
        if (!this.isEmpty()) return this.stack[top];
        throw new RuntimeException("数据为空");
    }

    /**
     * 获取栈的容量
     */
    public int stackLength() {
        //数组的总容量
        return this.stack.length;
    }

    /**
     * 计算两个数进行运算后的结果
     * 3 + 4
     * 3num1,4num2
     */
    public int calculate(int num1, int num2, int oper) {
        //计算结果
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result =  num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2/num1;
            default:
                break;
        }
        return result;
    }
}
