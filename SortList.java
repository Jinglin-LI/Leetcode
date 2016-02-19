// Sort a linked list in O(n log n) time using constant space complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // separate the linkedlist into two parts. recurse the two heads. merge the two heads.
 
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head, pre = head, dummyHead = head;
        while (fast != null && fast.next != null) {                         // use the fast and slow to find the middle listnode
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;        
        
        ListNode left = sortList(head);                                     // recurse, return the left and right heads
        ListNode right = sortList(slow);
        
        if (left.val < right.val) {                                         // this part set the dummyhead
            dummyHead = left;
            left = left.next;
        }
        else {
            dummyHead = right;
            right = right.next;
        }
        
        ListNode helper = dummyHead;                                        // merge the two parts
        while (left != null && right != null) {
            if (left.val < right.val) {
                helper.next = left;
                left = left.next;
                helper = helper.next;
            }
            else {
                helper.next = right;
                right = right.next;
                helper = helper.next;
            }
        }
        if (left == null)
            helper.next = right;
        else
            helper.next = left;
        return dummyHead;
    }
}
