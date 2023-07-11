package neetCode150.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_NoRepeat_Char {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>(s.length());
        while (i < s.length()) {
            if (set.add(s.charAt(i))) {
                i++;
                max = Math.max(set.size(), max);
            } else set.remove(s.charAt(j++));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
