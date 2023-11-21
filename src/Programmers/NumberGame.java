package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGame {
    public static void main(String[] args) {
        new NumberGame().solution2(new int[]{5,1,3,7}, new int[]{2,2,6,8});
    }
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
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (b.get(j) > a.get(i)) {
                count++;
                j++;
            }
        }
        return count;
    }
    public int solution2(int[] A, int[] B) {
        Arrays.sort(A); Arrays.sort(B);
        int count = 0, bIndex = B.length - 1;
        for (int i=bIndex; i>=0; i--) {
            if (B[bIndex] > A[i]) {
                count++; bIndex--;
            }
        }
        return count;
    }
}
