package neetCode150.ArrayHashing;

import java.util.*;

public class Valid_Anagram {
    private static boolean valid = true;
    private static int count;
    private static int index;
    public static boolean solution(String s, String t) {
        if (s.length() != t.length()) return false;
        String [] ss = s.split("");
        String [] ts = t.split("");

        return valid;
    }

    public static boolean simple_solution(String s, String t) {
        if (s.length() != t.length()) return false;
        String [] ss = s.split("");
        String [] ts = t.split("");

        Arrays.stream(ss).sorted().forEach(s1 -> ss[count++] = s1);
        count = 0;
        Arrays.stream(ts).sorted().forEach(s1 -> ts[count++] = s1);

        return valid = String.valueOf(ss).equals(String.valueOf(ts)) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(solution("rat", "car"));
    }
}
