package neetCode150.ArrayHashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Group_Anagrams {
    public static List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String[] sortStrs = Arrays.stream(strs).sorted((o1, o2) -> o1.compareTo(o2)).toArray(String[]::new);
        Arrays.stream(strs).map(s -> sortStrs(s))
                .filter(s -> !map.containsKey(s))
                .forEach(s ->  map.put(s, new ArrayList()));

        IntStream.range(0, strs.length)
                .filter(i -> map.get(sortStrs(sortStrs[i])) != null)
                .forEach(i -> map.get(sortStrs(sortStrs[i])).add(sortStrs[i]));

        return map.keySet().stream()
                .map(s -> map.get(s)).sorted((o1, o2) -> o1.size() - o2.size())
                .collect(Collectors.toList());
    }
    // 동일한 strs 값을 검사하기 위한 sort 작업
    private static String sortStrs(String strs) {
        return Arrays.stream(strs.split("")).sorted()
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> test = solution(str);
    }
}
