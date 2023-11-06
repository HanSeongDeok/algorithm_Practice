package ProgrammersPractice;

import java.util.*;
import java.util.stream.Collectors;

public class NightWork {
    public long solution(int n, int[] works) {
        return efficientWork(Arrays.stream(works)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()), n);
    }
    private long efficientWork(List<Integer> works, int n){
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(works);

        while (queue.peek() !=0 && n != 0) {
            queue.offer(queue.poll()-1);
            n--;
        }

        return queue.stream()
                .mapToLong(value -> (long) value * value)
                .sum();
    }
}
