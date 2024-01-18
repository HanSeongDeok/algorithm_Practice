package neetCode150.BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Time_Based_Key_Value_Store {
    Map<String, TreeMap<Integer, String>> timeMap;
    public Time_Based_Key_Value_Store() {
        timeMap = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key,map -> new TreeMap<>()).put(timestamp, value);
    }
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        if (timeMap.get(key).floorKey(timestamp) == null) return "";
        return timeMap.get(key).get(timeMap.get(key).floorKey(timestamp));
    }

    public static void main(String[] args) {
        Time_Based_Key_Value_Store test = new Time_Based_Key_Value_Store();
        test.set("love","high",10);
        test.set("love","low",20);
        System.out.println(test.get("love",5));
        System.out.println(test.get("love",10));
        System.out.println(test.get("love",15));
        System.out.println(test.get("love",20));
        System.out.println(test.get("love",25));
    }
}
