package com.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * Created by leng on 2021/03/11.
 */
public class No227 {
    public int calculate(String s) {
        //创建栈
        Deque<Integer> stack = new LinkedList<Integer>();
        //前符号
        char preSign = '+';
        //前位的数字
        int num = 0;
        int n = s.length();
        //遍历字符串
        for (int i = 0; i < n; ++i) {
            //如果为数字 则组合前一位数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //如果不为数字且不为空格 判断前符号 +号：将前数字正值入栈；-号：将前数字负值入栈；
            // *号：将栈顶出栈并与前数字相乘再入栈；/号：将栈顶出栈并除以前数字再入栈
            //重置前符号 重置前数字
            // 或者到达字符串末尾
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        //遍历完成，将只剩+-法的栈中数据累加
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
    public int calculate1(String s){
        Deque<Integer> stack=new LinkedList<>();
        int preSign='+';
        int num=0;
        int n = s.length();
        for (int i = 0; i <n ; i++) {
            if(Character.isDigit(s.charAt(i))){
                num=num*10+s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==n-1){
               switch (preSign){
                   case '+':
                       stack.push(num);
                       break;
                   case '-':
                       stack.push(-num);
                       break;
                   case '*':
                       stack.push(stack.pop()*num);
                       break;
                   default:
                       stack.push(stack.pop()/num);
               }
               preSign=s.charAt(i);
               num=0;
            }
        }
        int answer=0;
        while (!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
}
