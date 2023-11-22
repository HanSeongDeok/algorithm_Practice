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

    public int solution3(int n, int[][] computers) {
        boolean[] checked = new boolean[n];
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!checked[i]) {
                count = dfsCheck2(i, computers, checked, count);
            }
        }
        return count;
    }
    private int dfsCheck2(int i, int[][] computers, boolean[] checked, int count) {
        checked[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (!checked[j] && computers[i][j] == 1) dfsCheck2(j, computers, checked, count);
        }
        return ++count;
    }
    private int dfsCheckStack2(int i, int[][] computers, boolean[] checked, int count){
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            checked[index] = true;
            for (int j = 0; j < computers.length; j++) {
                if (!checked[j] && computers[index][j] == 1) stack.push(j);
            }
        }
        return ++count;
    }

    public int solution4(int n, int[][] computers) {
        boolean[] checked = new boolean[computers.length];
        int count = 0;
        for (int i=0; i<computers.length; i++) {
            if (!checked[i]) count = dfsCheck3(checked, computers, i, count);
        }
        return count;
    }

    private int dfsCheck3(boolean[] checked, int[][] computers, int i, int count) {
        checked[i] = true;
        for (int k = 0; k < computers.length; k++) {
            if (!checked[k] && computers[i][k] == 1) count = dfsCheck3(checked, computers, k, count);
        }
        return ++count;
    }
}
