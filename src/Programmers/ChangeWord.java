package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        boolean[] changed = new boolean[words.length];
        int count = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int size = 0; size < queueSize; size++){

                String changeNext = queue.poll();
                if (changeNext.equals(target)) return count;

                for (int i = 0; i < words.length; i++) {
                    if (!changed[i]) {
                        changed[i] = validChanged(words, changed, changeNext, i);
                        if (changed[i]) queue.add(words[i]);
                     }
                }
            }
            count++;
        }
        return 0;
    }
    private boolean validChanged(String[] words, boolean[] changed, String changeNext, int i) {
        int count = 0;
        for (int j = 0; j < words[i].length(); j++) {
            if (changeNext.charAt(j) == words[i].charAt(j)) count++;
            if (count > 1) changed[i] = true;
        }
        return changed[i];
    }

    public static void main(String[] args) {
        new ChangeWord().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }
}
