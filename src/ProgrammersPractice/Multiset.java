package ProgrammersPractice;

import java.util.Arrays;

public class Multiset {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int multiset[] = null;
        int rest = s % n;
        Arrays.fill(multiset, s / n);
        for (int i = 0; i < rest; i++) {
            multiset[i] += 1;
        }
        Arrays.sort(multiset);
        return multiset;
    }
}
