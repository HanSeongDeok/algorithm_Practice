package LeetCodeReivew;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagramsReview {
    public static List<List<String>> solution(String[] strs){
        Map<String, List<String>> map = new HashMap();
        List<List<String>> solution = new ArrayList();
        for (int i =0; i<strs.length; i++){
            List<String> temp = map.get(Arrays.stream(strs[i].split(""))
                    .sorted()
                    .collect(Collectors.joining()));
            if(temp!=null){
                temp.add(strs[i]);
            } else {
                temp = new ArrayList();
                temp.add(strs[i]);
                map.put(Stream.of(strs[i].split(""))
                        .sorted()
                        .collect(Collectors.joining()), temp);
            }
        }
        for(List<String> temp : map.values()){
            solution.add(temp.stream().sorted().toList());
        }
        return solution.stream().sorted((o1, o2) -> o1.size()-o2.size()).toList();
    }
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        for(List<String> temp : solution(strs)){
            String test = Arrays.toString(temp.stream().toArray(String[]::new));
            System.out.println(test);
        }
    }
}
