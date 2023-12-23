package practice;

import java.util.*;

public class StreamPractice {
    public List<String> test(){
        List<String> contList = Arrays.asList("aaa bbb ccc ddd eee".split(" "));
        Queue<String> q = new LinkedList<>(contList);
        Queue<String> p = new LinkedList<>(contList);
        q.stream()
                .map(v -> StreamPracticeFunc.defaultFunc(p, v))
                .filter(StreamPracticeFunc::filterTest)
                .forEach(StreamPracticeFunc::print);
        return contList;
    }
    public static void main(String[] args) {
        new StreamPractice().test();
    }
}
