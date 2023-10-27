package Programmers;

import java.util.*;

public class Operations {
    public int[] solution(String[] operations) {
        //TODO Queue 이용해서 풀어봐야 함.
        Map<Integer, String> queueMap = new HashMap<>();
        for (String o : operations) {
            String order = o.split(" ")[0];
            String value = o.split(" ")[1];
            if (order.equals("I"))  queueMap.put(Integer.parseInt(value), order);
            if (order.equals("D") && value.equals("1") && !queueMap.isEmpty()) queueMap.remove(queueMap.keySet()
                    .stream()
                    .max(Integer::compareTo)
                    .orElseGet(() -> 0));
            if (order.equals("D") && value.equals("-1") && !queueMap.isEmpty()) queueMap.remove(queueMap.keySet()
                    .stream()
                    .min(Integer::compareTo)
                    .orElseGet(() -> 0));
        }
        return queueMap.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
