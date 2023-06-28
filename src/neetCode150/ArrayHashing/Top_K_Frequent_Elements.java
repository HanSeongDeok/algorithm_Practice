package neetCode150.ArrayHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        Arrays.stream(nums)
                .filter(i -> !map.containsKey(i))
                .forEach(i -> map.put(i, count));

        Arrays.stream(nums)
                .forEach(i -> map.put(i, map.get(i)+1));

        return  map.keySet().stream()
                .sorted((o1, o2) -> map.get(o2) - map.get(o1)).limit(k)
                .mapToInt(Integer::intValue).toArray();
    }
}
