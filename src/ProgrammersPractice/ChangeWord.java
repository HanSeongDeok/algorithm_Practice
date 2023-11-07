package ProgrammersPractice;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    public int solution(String begin, String target, String[] words) {
        boolean checked[] = new boolean[words.length];
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        int count = 0;
        while (!queue.isEmpty()) {
            for (int k = 0; k < queue.size(); k++) {
                String word = queue.poll();
                if (target.equals(word)) return count;
                changeWordEfficiently(words, checked, queue, word);
            }
            count++;
        }
        return 0;
    }
    private void changeWordEfficiently(String[] words, boolean[] checked, Queue<String> queue, String word) {
        for (int i = 0; i< words.length; i++) {
            if (!checked[i] && validChange(word, words[i])) {
                queue.offer(words[i]);
                checked[i] = true;
            }
        }
    }
    private boolean validChange(String word, String changeWord) {
        int diff = 0;
        for (int j = 0; j< word.length(); j++){
            if (word.charAt(j) != changeWord.charAt(j)) diff++;
            if (diff>1) return false;
        }
        return true;
    }
}
