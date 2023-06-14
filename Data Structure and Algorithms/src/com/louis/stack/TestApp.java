package com.louis.stack;

/**
 * @Louis Restart
 * @date 2023/5/13 0013 21:00
 */
public class TestApp {
    public static void main(String[] args) {
        //System.out.println(palindrome("hello"));
        System.out.println(palindrome("����"));
    }
    public static boolean palindrome(String val){
        //��ʼ��ջ����
        ArrayStack arrayStack = new ArrayStack(10);

        //��ȡ�ַ�������
        int length = val.length();
        //���ַ���������λ�ȡ��ѹջ��������
        for(int i = 0;i < length;i++){
            arrayStack.push(val.charAt(i));
        }

        //��ȡ
        StringBuilder newVal = new StringBuilder();
        //��ȡջ�г��� ע�⣬���ֵ�����ŵ�ջ������
        //������Ҫ�ڵ�ջǰ�ͻ�ȡ
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
