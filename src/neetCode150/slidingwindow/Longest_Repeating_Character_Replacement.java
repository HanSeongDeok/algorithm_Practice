package neetCode150.slidingwindow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    private Integer getMaxWindow2(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, windowMax = 0, right = 0, left = 0;

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
            max = Math.max(map.get(c), max);

            if (right - left + 1 - max > k) map.put(s.charAt(left), map.get(s.charAt(left++))-1);
            windowMax = Math.max(windowMax, right++ - left +1);
        }
        return windowMax;
    }

    /**
     * WOW BEST!!!
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement4(String s, int k) {
        byte[] array = s.getBytes();
        //System.out.print(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) array[i] -= 'A';
        int[] count = new int[26];
        int start = 0;
        for (int end = 0, maxCount = 0; end < array.length; end++) {
            maxCount = Math.max(maxCount, ++count[array[end]]);
            while (maxCount + k < end - start + 1) count[array[start++]]--;
        }
        return array.length - start;
    }

    public static void main(String[] args) {
        System.out.println(new Longest_Repeating_Character_Replacement().getMaxWindow2("AABABBA", 1));
    }
}
