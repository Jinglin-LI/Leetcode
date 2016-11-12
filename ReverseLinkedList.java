/*
Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// 非递归

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        if (pre == null) 
            return null;
        if (pre.next == null)
            return pre;
        ListNode cur = pre.next;
        pre.next = null;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }
}


/*==========================================================*/	
// 递归
	
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
