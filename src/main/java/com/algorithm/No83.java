package com.algorithm;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * Created by leng on 2021/03/26.
 */
public class No83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode virtualNode = new ListNode(0, head);
        ListNode cur=virtualNode;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int val = cur.next.val;
                while(cur.next.next!=null&&cur.next.next.val==val){
                    cur.next=cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return virtualNode.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
