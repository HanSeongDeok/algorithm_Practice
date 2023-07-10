package neetCode150.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_NoRepeat_Char {
    public static int lengthOfLongestSubstring(String s) {
        int index = 0, max = 0;
        Set<Character> set = new HashSet();
        while (index < s.length()) {
            if (!set.add(s.charAt(index++))){
                max = Math.max(set.size(), max);
            } else set.remove(s.charAt(index++));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
