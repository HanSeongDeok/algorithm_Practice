package neetCode150.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() ==0 || t.length() == 0 ||
                    s.length() < t.length()) {
                return new String();
            }
            int[] map = new int[128];
            int count = t.length();
            int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex =0;
            for (char c :t.toCharArray()) {
                map[c]++;
            }
            char[] chS = s.toCharArray();
            while (end < chS.length) {
                if (map[chS[end++]]-- >0) {
                    count--;
                }
                while (count == 0) {
                    if (end - start < minLen) {
                        startIndex = start;
                        minLen = end - start;
                    }
                    if (map[chS[start++]]++ == 0) {
                        count++;
                    }

                }
            }
            return minLen == Integer.MAX_VALUE? new String():
                    new String(chS,startIndex,minLen);
        }

    public String minWindow2(String s, String t) {
        if (s == null || t==null || s.isEmpty() || t.isEmpty() || t.length() > s.length() ) return "";
        char [] sArr = s.toCharArray();
        int [] tArr = new int[128];
        IntStream.range(0,t.length()).forEach(i -> tArr[t.charAt(i)]++);
        int start=0, end=0, count=t.length(), minWindow=Integer.MAX_VALUE, startIndex = 0;
        while (end < s.length()) {
            if (tArr[sArr[end++]]-- > 0) count--;
            while (count == 0) {
                if (end - start < minWindow){
                    startIndex = start;
                    minWindow = end - start;
                }
                if (tArr[sArr[start++]]++ == 0) count++;
            }
        }
        return minWindow==Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minWindow);
    }

    public String minWindow3(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || t.length() > s.length()) return "";
        int count = t.length(), end = 0, start = 0, minWindow = Integer.MAX_VALUE, startIndex = 0;
        char[] sArr = s.toCharArray();
        int [] tArr = new int[128];
        IntStream.range(0, t.length()).forEach(i -> tArr[t.charAt(i)]++);
        while (end < s.length()) {
            if (tArr[sArr[end++]]-- > 0) count--;
            while (0 == count) {
                if (end - start < minWindow) {
                    startIndex = start;
                    minWindow = end - start;
                }
                count = (tArr[sArr[start++]]++ == 0) ? count+1 : count;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : new String(s.toCharArray(), startIndex, minWindow);
    }

    public static void main(String[] args) {
        System.out.println(new Minimum_Window_Substring().minWindow3("ADOBECODEBANC","ABC"));
    }
}
