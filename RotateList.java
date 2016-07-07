/*
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
// In my understanding, put the last node to the first, repeat k times. 我的理解是，每次把最后的元素rotate到第一个，重复k次。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        if (head == null)
            return dummyHead.next;
            
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        k %= size;
        
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }
}
