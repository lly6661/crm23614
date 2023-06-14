package com.louis.stack;

/**
 * @Louis Restart
 * @date 2023/5/13 0013 21:00
 */
public class TestApp {
    public static void main(String[] args) {
        //System.out.println(palindrome("hello"));
        System.out.println(palindrome("冰冰"));
    }
    public static boolean palindrome(String val){
        //初始化栈对象
        ArrayStack arrayStack = new ArrayStack(10);

        //获取字符串长度
        int length = val.length();
        //把字符串数据逐次获取，压栈至数组中
        for(int i = 0;i < length;i++){
            arrayStack.push(val.charAt(i));
        }

        //获取
        StringBuilder newVal = new StringBuilder();
        //获取栈中长度 注意，这个值会随着弹栈而减少
        //所以需要在弹栈前就获取
        int stackLength = arrayStack.length();
        for (int i = 0; i < stackLength; i++) {
            if(!arrayStack.isEmpty()){
                char pop = (char)arrayStack.pop();
                newVal.append(pop);
            }
        }
        return val.equals(newVal.toString());
    }
}
