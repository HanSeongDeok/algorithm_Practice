package neetCode150.stack;

import java.util.Map;
import java.util.Stack;

public class Min_Stack {
    int min;
    Stack<Integer> stack;
    public Min_Stack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    public void push(int val) {
        if (Math.min(val, min) == val){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
}

class MinStack{
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin();
    }
}