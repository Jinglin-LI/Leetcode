/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;
        dummyHead.next = head;
        
        p2 = p2.next;
        while (p2 != null) {
            if (!hs.contains(p2.val)) {
                hs.add(p2.val);
                p2 = p2.next;
                p1 = p1.next;
            }
            else {
                p1.next = p2.next;
                p2 = p2.next;
            }
        }
        return dummyHead.next;
    }
}
