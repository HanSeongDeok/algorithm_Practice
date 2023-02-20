package LeetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static List<List<String>> solution(String[] strs){
        Map<String, List<Integer>> map = new HashMap();
        List solution = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            if(map.get(Stream.of(strs[i].split(""))
                    .sorted()
                    .collect(Collectors.joining()))!=null){
                List<Integer> temp = map.get(Stream.of(strs[i].split(""))
                        .sorted()
                        .collect(Collectors.joining()));
                temp.add(i);
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(Stream.of(strs[i].split(""))
                        .sorted()
                        .collect(Collectors.joining()),temp);
            }
        }
        for(List print : map.values().stream().sorted((o1, o2)->o1.size()- o2.size()).toList()){
            solution.add(print.stream().map(x->{
                return strs[(int) x];
            }).sorted().toList());
        }
        return solution;
    }
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
    }
}
