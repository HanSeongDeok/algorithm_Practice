package study;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ParenthesisString {
    boolean solution(String string) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(string.split("")));
        int count = 0;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (count == 0 && s.equals(")")) return false;
            else if (s.equals(")")) count--;
            else if (s.equals("(")) count ++;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ParenthesisString().solution("(()(("));
    }
}
