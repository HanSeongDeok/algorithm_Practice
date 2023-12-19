package ProgrammersPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Operation {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
  /*      Deque<Integer> dq = new ArrayDeque<>();
        dq.remove(dq.stream().mapToInt(Integer::intValue).min().getAsInt());*/
        for (String o : operations){
            if (o.charAt(0) == 'I') {
                maxQueue.offer(Integer.parseInt(o.substring(2)));
                minQueue.offer(Integer.parseInt(o.substring(2)));
            }
            if (o.charAt(0) == 'D' && o.charAt(2) == '-') maxQueue.remove(minQueue.poll());
            if (o.charAt(0) == 'D' && o.charAt(2) == '1') minQueue.remove(maxQueue.poll());
        }

        if (maxQueue.isEmpty() && minQueue.isEmpty()) return new int[]{0,0};
        return new int[]{maxQueue.element(), minQueue.element()};
    }

    public int[] solution2(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for (String o : operations) {
            if (o.charAt(0) == 'I') {
                maxQ.offer(Integer.parseInt(o.substring(2)));
                minQ.offer(Integer.parseInt(o.substring(2)));
            }
            if (o.charAt(0) == 'D' && o.substring(2).equals("1")) minQ.remove(maxQ.poll());
            if (o.charAt(0) == 'D' && o.substring(2).equals("-1")) maxQ.remove(minQ.poll());
        }
        if (maxQ.isEmpty() || minQ.isEmpty()) return new int[]{0,0};
        return new int[]{maxQ.poll(),minQ.poll()};
    }

    public static void main(String[] args) {
        Arrays.stream(new Operation().solution2(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))
                .forEach(System.out::println);
    }
}
