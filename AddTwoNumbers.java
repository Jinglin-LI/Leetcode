// 这道题是正着加，不要想复杂了。2+5 = 第一个7， 4+6=第二个0， 然后3+4+1（进位）是第三个8.
/**
此题注意建立新的node, 用curr.next = new ListNode(val);
*/
/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
(The digits are stored in order)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
import java.util.*;
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i = (l1 != null)? l1.val : 0;
            int j = (l2 != null)? l2.val : 0;
            int total = i + j + + carry;
            p.next = new ListNode(total % 10);
            carry = total / 10;
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
/////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		int carry = 0;
		
		while (p1 != null || p2 != null) {
			int v1 = (p1 != null)? p1.val : 0;
			int v2 = (p2 != null)? p2.val : 0;
			int digit = v1 + v2 + carry;
			carry = digit / 10;
			curr.next = new ListNode(digit % 10);
			curr = curr.next;
			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
		}
		if (carry != 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode dummyHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, curr = dummyHead;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			int digit = carry % 10;
			curr.next = new ListNode(digit);
			curr = curr.next;
			carry /= 10;
		}
		if (carry != 0)
			curr.next = new ListNode(carry);
		return dummyHead.next;
	}
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = new ListNode(0);
        p = dummyHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int digit = l1.val + l2.val + carry;
            
            p.next = new ListNode(digit % 10);
          
            carry = digit / 10;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        while (l1 != null) {
            int digit = l1.val + carry;
            p.next = new ListNode(digit % 10);
            carry = digit / 10;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int digit = l2.val + carry;
            p.next = new ListNode(digit % 10);
            carry = digit / 10;
            p = p.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
