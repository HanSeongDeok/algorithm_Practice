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
    public int solution2(String begin, String target, String[] words) {
        Queue<String> changeWordQueue = new LinkedList<>();
        changeWordQueue.offer(begin);
        int count = 0;
        boolean[] checked = new boolean[words.length];
        while (!changeWordQueue.isEmpty()) {
            int queueSize = changeWordQueue.size();
            for (int i=0; i<queueSize; i++){
                String word = changeWordQueue.poll();
                if (target.equals(word)) return count;
                // 바뀔 수 있는 단어 목록을 큐에 추가
                changeWordQueue = settingNextChangeQueue(word, checked, words, changeWordQueue);
            }
            count++;
        }
        return 0;
    }
    private Queue<String> settingNextChangeQueue(String word, boolean[] checked, String[] words, Queue<String> changeWordQueue) {
        int index = 0;
        for (String changeWord : words) {
            boolean isPossibleToChangeWord = validPossibleToChangeWord(changeWord, word);
            if (!checked[index] && isPossibleToChangeWord) {
                checked[index] = true;
                changeWordQueue.offer(changeWord);
            }
            index++;
        }
        return changeWordQueue;
    }
    private boolean validPossibleToChangeWord(String changeWord, String word) {
        int count = 0, index = 0;
        for (char c : changeWord.toCharArray()) {
            // 차이 수 check;
            if (word.charAt(index++) != c) count++;
        }
        // 0 = 자기 자신
        // 1 = 변경 가능
        // 나머지 = 다른 단어 2가지 이상
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new ChangeWord().solution2("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
