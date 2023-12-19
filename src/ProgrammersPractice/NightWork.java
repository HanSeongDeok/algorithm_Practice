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

    public long solution2(int n, int[] works) {
        while (n != 0){
            int maxIndex = findMaxIndex(works);
            if (works[maxIndex] == 0) return 0;
            works[maxIndex] -= 1;
            n--;
        }
        return Arrays.stream(works)
                .mapToLong(value -> (long) value * value)
                .sum();
    }
    private int findMaxIndex(int[] works) {
        int maxIndex = 0;
        for (int i=0; i < works.length; i++) {
            if (works[i] > works[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    public long solution3(int n, int[] works) {
        Arrays.sort(works);
        while (n != 0) {
            int index = invokeMaxIndex(works);
            if (works[index] == 0) return 0;
            works[index]--; n--;
        }
        int count = 0;
        for (int w : works) {
            count += w * w;
        }
        return count;
    }

    private int invokeMaxIndex(int[] works) {
        int maxIndex = 0, maxValue = 0;
        for (int i = works.length-1; i>=0; i--) {
            maxValue = Math.max(maxValue, works[i]);
            if (maxValue == works[i]) maxIndex = i;
        }
        return maxIndex;
    }

    private int invokeMaxIndex2(int[] works) {
        int maxIndex = 0;
        for (int i = works.length-1; i>=0; i--) {
            if (works[i] > works[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(new NightWork().solution3(4, new int[]{4,3,3}));
    }
}
