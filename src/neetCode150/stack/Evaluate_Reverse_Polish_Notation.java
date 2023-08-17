package neetCode150.stack;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int sufNumber = stack.pop();
                    int preNumber = stack.pop();
                    stack.push(preNumber - sufNumber);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    sufNumber = stack.pop();
                    preNumber = stack.pop();
                    stack.push(preNumber / sufNumber);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
// ["2","1","+","3","*"] => ((1 + 2) * 3)
// ["4","13","5","/","+"] => (4 + (13 / 5))