/*
Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
*/

class MyStack {
    // Push element x onto stack.
    Queue<Integer> q = new LinkedList<Integer>();
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            temp.add(q.poll());
        }
        q.poll();
        while (!temp.isEmpty()) {
            q.add(temp.poll());
        }
    }

    // Get the top element.
    public int top() {
        Queue<Integer> temp = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            temp.add(q.poll());
        }
        int res = q.poll();
        while (!temp.isEmpty())
            q.add(temp.poll());
        q.add (res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
