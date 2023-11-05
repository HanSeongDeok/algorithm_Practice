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
}
