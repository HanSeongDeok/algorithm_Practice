package neetCode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Longest_Repeating_Character_Replacement {
    // Time Complexity :  O(n)
// Space Complexity : O(1)
        public int characterReplacement(String s, int k) {
            int[] arr = new int[26];
            int largestCount = 0, beg = 0, maxlen = 0;
            for(int end = 0; end < s.length(); end ++){
                largestCount = Math.max(largestCount, ++arr[s.charAt(end) - 'A']);
                if(end - beg + 1 - largestCount > k){
                    arr[s.charAt(beg++) - 'A']--;
                }
                maxlen = Math.max(maxlen, end - beg + 1);
            }
            return maxlen;
        }
        int max = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        public int characterReplacement2(String s, int k) {
            return getMaxWindow(s, k);
        }
    private Integer getMaxWindow(String s, int k) {
        return IntStream.range(0, s.length())
                .map(i -> {
                    if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 0);
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    max = Math.max(max, map.get(s.charAt(i)));
                    return i;
                }).mapToObj(i -> {
                    if (i - j + 1 - max > k) map.put(s.charAt(j), map.get(s.charAt(j++)) - 1);
                    return i - j + 1;
                }).max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        new Longest_Repeating_Character_Replacement().characterReplacement2("ABAB", 2);
    }
}
