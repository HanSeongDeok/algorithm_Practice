package neetCode150.stack;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < temperatures.length; i++) {
            while (stack.size() > 0 && temperatures[i] > temperatures[stack.peek()]) {
                temperatures[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        if (!stack.isEmpty()) stack.forEach(i -> temperatures[i] = 0);
        return temperatures;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
