package neetCode150.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static int lengthOfLongestSubstring2(String s) {
        int startIndex = 0, endIndex = 0, windowMax = 0;
        Set<Character> set = new HashSet<>();
        while (endIndex < s.length()) {
            if (set.add(s.charAt(endIndex))) {
                endIndex++;
                windowMax = Math.max(windowMax, set.size());
            } else set.remove(s.charAt(startIndex++));
        }
        return windowMax;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
