/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    public Stack<Integer> stack = new Stack<Integer>();
    public Stack<Integer> minstack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || minstack.peek() >= x)
            minstack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(minstack.peek()))
            minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
