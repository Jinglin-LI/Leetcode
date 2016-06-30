/*
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) 
            return null;
        HashSet<ListNode> hs = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while (tempA != null) {
            hs.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (!hs.contains(tempB))
                tempB = tempB.next;
            else
                return tempB;
        }
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if (lenA >= lenB) {
            int gap = lenA - lenB;
            while (gap-- > 0) 
                p1 = p1.next;
        } else {
            int gap = lenB - lenA;
            while (gap-- > 0)
                p2 = p2.next;
        }
        while (p1 != null && p2 != null) {
            if (p1.equals(p2))
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
