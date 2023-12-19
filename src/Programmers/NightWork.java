package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class NightWork {
    public long solution(int n, int[] works) {
        return efficientSearchFor(Arrays.stream(works)
                .boxed()
                .collect(Collectors.toList()), n);
    }
    private long efficientSearchFor(List<Integer> works, int n) {
        if (works == null || works.size() == 0) return 0;
        long answer = 0;
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(works);

        while (pq.peek() != 0 && n != 0) {
            pq.offer(pq.poll() - 1);
            n--;
        }

        for (long value : pq) {
            answer += value * value;
        }

        return answer;
    }

    public long solution2(int n, int[] works){
        if (works == null || works.length == 0) return 0;
        long answer = 0;
        Arrays.sort(works);
        while (n > 0 && works[works.length-1] > 0) {
            int max = works[works.length-1];
            for (int i = works.length-1; i >= 0; i--){
                if (n != 0 && works[i] == max) {
                    works[i] --;
                    n--;
                } else break;
            }
        }
        for (long value : works){
            answer += value * value;
        }
        return answer;
    }

    public static void main(String[] args) {
        new NightWork().solution2(1, new int[]{2,1,2});
    }
}
