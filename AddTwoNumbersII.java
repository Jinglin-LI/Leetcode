/*
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		int sum = 0;
		ListNode curNode = new ListNode(0);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}
			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
      // 从后向前, head每次往前走，curNode 指向head, 最后返回head
			ListNode head = new ListNode(sum / 10);
			curNode.val = sum % 10;
			head.next = curNode;
			
			curNode = head;
			sum /= 10;
		}
		
		// if the sum == 0 and the head becomes 0
		if (curNode.val == 0) {
			return curNode.next;
		}
		return curNode;
    }
}
