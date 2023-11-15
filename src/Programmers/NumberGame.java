package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        List<Integer> a = Arrays.stream(A)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> b = Arrays.stream(B)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (b.get(i) > a.get(i)) count += 1;
        }
        return count;
    }
    public int solution2(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0;
        int bIndex = B.length - 1;
        for (int a : A) {
            while (bIndex >= 0 && B[bIndex] <= a) {
                bIndex--;
            }
            if (bIndex >= 0) {
                count++;
                bIndex--;
            }
        }
        return count;
    }
}
