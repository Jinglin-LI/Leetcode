/*
Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
*/

class MyStack {
    Queue<Integer> q = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        int size = q.size();
        while (size > 1) {
            q.add(q.poll());
            size--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}


import java.util.*;
public class Mystack2 {
	public static void main(String[] args) {
		Mystack a = new Mystack();
		a.push(1);
		a.push(2);
		System.out.println(a.top());
		a.pop();
		System.out.println(a.top());
		a.pop();
		if (a.empty())
			System.out.println("Empty");	
	}
	Queue<Integer> q = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty() && q.size() != 1) {
            temp.add(q.poll());
        }
        q = temp;
    }

    // Get the top element.
    public int top() {
        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty() && q.size() != 1) {
            temp.add(q.poll());
        }
        int res = q.peek();
        temp.add(res);
        q = temp;
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
