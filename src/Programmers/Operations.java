package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {
    public int[] solution(String[] operations) {
        Map<Integer, String> map = new HashMap<>();
        for (String o : operations) {
            String order = o.split(" ")[0];
            String value = o.split(" ")[1];
            if (order.equals("I"))  map.put(Integer.parseInt(value), order);
            if (order.equals("D") && value.equals("1") && !map.isEmpty()) map.remove(map.keySet()
                    .stream()
                    .max(Integer::compareTo)
                    .orElseGet(() -> 0));
            if (order.equals("D") && value.equals("-1") && !map.isEmpty()) map.remove(map.keySet()
                    .stream()
                    .min(Integer::compareTo)
                    .orElseGet(() -> 0));
        }
        if (map.isEmpty()) return new int[]{0,0};
        return new int[]{map.keySet().stream().mapToInt(Integer::intValue).max().getAsInt(),
                map.keySet().stream().mapToInt(Integer::intValue).min().getAsInt()};
    }

    public int[] solution2(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String i : operations){
            String order = i.split(" ")[0];
            String value = i.split(" ")[1];
            int v = Integer.parseInt(i.substring(2));
            if (order.equals("I")) deque = addValueInSortedDeque(v, deque);
            if (order.equals("D") && value.equals("1")) deque.pollLast();
            if (order.equals("D") && value.equals("-1")) deque.pollFirst();
        }
        if (deque.isEmpty()) return new int[] {0, 0};
        return new int[]{deque.peekLast(), deque.peekFirst()};
    }

    private Deque<Integer> addValueInSortedDeque(Integer v, Deque<Integer> deque) {
        boolean firstOrLastOfferCheck = false;
        if (!deque.isEmpty() && deque.peekFirst() >= v) firstOrLastOfferCheck = deque.offerFirst(v);
        if (!deque.isEmpty() && deque.peekLast() <= v) firstOrLastOfferCheck = deque.offerLast(v);
        if (!firstOrLastOfferCheck) {
            deque.add(v);
            if (deque.size() == 1) return deque;
            deque = deque.stream()
                    .sorted(Integer::compareTo)
                    .collect(Collectors.toCollection(ArrayDeque::new));
        }
        return deque;
    }

    public int[] solution3(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String o : operations) {
            if (o.startsWith("I")) {
                maxQ.offer(Integer.parseInt(o.substring(2)));
                minQ.offer(Integer.parseInt(o.substring(2)));
            }
            if (o.startsWith("D") && o.substring(2).equals("1")) minQ.remove(maxQ.poll());
            if (o.startsWith("D") && o.substring(2).equals("-1")) maxQ.remove(minQ.poll());
        }
        if (maxQ.isEmpty() && minQ.isEmpty()) return new int[]{0,0};
        return new int[]{maxQ.element(), minQ.element()};
    }

    public static void main(String[] args) {
        String[] test = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] test2 = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(new Operations().solution3(test2)));
    }
}
