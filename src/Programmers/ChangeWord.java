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
        return isValidChange(words[i], changeNext, changed, i);
    }

    public int solution2(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] checked = new boolean[words.length];
        queue.offer(begin);
        int count = 0;
        return bfsCount(target, words, queue, checked, count);
    }
    private int bfsCount(String target, String[] words, Queue<String> queue, boolean[] checked, int count) {
        if (queue.isEmpty()) return 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (target.equals(queue.peek())) return count;
                setChangedQueue(words, queue, checked, queue.poll());
            }
            return bfsCount(target, words, queue, checked, ++count);
    }
    private void setChangedQueue(String[] words, Queue<String> queue, boolean[] checked, String nextChangeWord) {
        for (int j = 0; j < words.length; j++) {
            if (!checked[j] && isValidChange(nextChangeWord, words[j], checked, j)) queue.offer(words[j]);
        }
    }
    private boolean isValidChange(String nextChangeWord, String words, boolean[] checked, int j) {
        int subCount = 0;
        for (int k = 0; k < nextChangeWord.length(); k++) {
            if (words.charAt(k) != nextChangeWord.charAt(k)) subCount++;
        }
        return checked[j] = subCount <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new ChangeWord().solution2("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
