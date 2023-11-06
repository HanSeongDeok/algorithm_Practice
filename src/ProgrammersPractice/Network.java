package ProgrammersPractice;

import java.util.Stack;

public class Network {
    public int solution(int n, int[][] computers) {
        boolean checkLinked[] = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!checkLinked[i]) answer = dfsCheck(i, checkLinked, answer, computers);
        }
        return answer;
    }
    private int dfsCheck(int index, boolean[] checkLinked, int answer, int[][] computers) {
        checkLinked[index] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!checkLinked[i] && computers[index][i] == 1) dfsCheck(i, checkLinked, answer, computers);
        }
        return ++answer;
    }

    public int solution2(int n, int[][] computers) {
        boolean[] checkLinked = new boolean[n];
        int answer = 0;
        for (int i=0; i < n; i++) {
            if (!checkLinked[i]) answer = dfsCheckStack(i, answer, checkLinked, computers);
        }
        return answer;
    }

    private int dfsCheckStack(int i, int answer, boolean[] checkLinked, int[][] computers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            checkLinked[index] = true;
            for (int j = 0; j < computers.length; j++) {
                if (!checkLinked[j] && computers[index][j] == 1) stack.push(j);
            }
        }
        return ++answer;
    }
}
