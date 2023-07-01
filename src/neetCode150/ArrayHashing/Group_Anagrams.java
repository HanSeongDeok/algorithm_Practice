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
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (Optional.ofNullable(strs).isEmpty()) return new ArrayList();
        if (strs.length == 1) {
            List<List<String>> groupAnagrams = new ArrayList<>();
            groupAnagrams.add(Arrays.stream(strs).toList());
            return groupAnagrams;
        }
        Map<String, List<String>> map = new HashMap();
        String [] sortedStrs = Arrays.stream(strs).sorted().toArray(String[]::new);

    return IntStream.range(0, sortedStrs.length).mapToObj(index -> {
                 String sortedChar = sortingChars(sortedStrs[index]);
                 if (!map.containsKey(sortedChar)) map.put(sortedChar, new ArrayList());
                 return sortedStrs[index];
             }).map(s -> {
                 List<String> listTemp = map.get(sortingChars(s));
                 listTemp.add(s);
                 return listTemp;
            }).toList().stream().sorted((o1, o2) -> o1.size() - o2.size()).distinct().toList();
    }
    // sorting Chars in Str
    private static String sortingChars(String sortedStrs) {
        return Arrays.toString(Arrays.stream(sortedStrs.split("")).sorted().toArray(String[]::new));
    }

    // 동일한 strs 값을 검사하기 위한 sort 작업
    private static String sortStrs(String strs) {
        return Arrays.stream(strs.split("")).sorted()
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String[] str = {"a"};
        List<List<String>> test = groupAnagrams(str);
    }
}
