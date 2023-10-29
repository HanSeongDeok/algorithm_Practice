package Programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean checked[] = new boolean[computers.length];
        for (int i = 0; i < n; i ++) {
           if (!checked[i]) answer = dfsCheck(
                   checked,
                   computers,
                   i ,
                   answer);
        }
        return answer;
    }
    private int dfsCheck(boolean[] checked, int[][] computer, int i, int answer) {
        checked[i] = true;
        for (int index = 0; index < computer.length; index++) {
            if (computer[i][index] == 1 && !checked[index]) dfsCheck(
                    checked,
                    computer,
                    index,
                    answer);
        }
        return ++answer;
    }

    private int stackCheck(boolean[] checked, int[][] computer, int i, int answer) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            checked[index] = true;
            for (int k = 0; k < computer.length; k++) {
                if (computer[index][k] == 1 && !checked[k]) stack.push(k);
            }
        }
        return ++answer;
    }

    private int qCheck(boolean[] checked, int[][] computer, int i, int answer) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int index = q.poll();
            checked[index] = true;
            for (int k = 0; k < computer.length; k++) {
                if (computer[index][k] == 1 && !checked[k]) q.offer(k);
            }
        }
        return ++answer;
    }
}
