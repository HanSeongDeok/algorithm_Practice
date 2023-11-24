package ProgrammersPractice;

import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); Arrays.sort(B);
        int bIndex = B.length-1, count = 0;
        for (int i = A.length-1; i >= 0; i--) {
            if (A[i] < B[bIndex]) {
                bIndex--; count++;
            }
        }
        return count;
    }
}
