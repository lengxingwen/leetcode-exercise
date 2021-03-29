package com.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * Created by leng on 2021/03/12.
 */
public class No331 {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        //遍历字符串的计数器
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        //放入一个槽位
        stack.push(1);
        while (i < n) {
            //当字符串未遍历完成，没有槽位时，不符合条件
            if (stack.isEmpty()) {
                return false;
            }
            //跳过逗号
            if (preorder.charAt(i) == ',') {
                i++;
            //遍历到空节点时 栈顶的槽位数-1后若>0，入栈
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            //遍历到数字末尾的逗号，栈顶的槽位数-1后若>0，入栈；然后将2个槽位入栈
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        //遍历结束 若栈为空 则说明所有槽位都刚好被使用，否则说明有剩余槽位，不符合条件
        return stack.isEmpty();
    }

    //计数取代栈
    public boolean isValidSerialization1(String preorder){
        int stack=1;
        int i=0;
        int length = preorder.length();
        while (i<length){
            if(stack<=0){
                return false;
            }
            if(preorder.charAt(i)==','){
                i++;
            }else if(preorder.charAt(i)=='#'){
                stack--;
                i++;
            }else {
                while(i<length&&preorder.charAt(i)!=','){
                    i++;
                }
                stack++;
            }
        }
        return stack==0;
    }
}
