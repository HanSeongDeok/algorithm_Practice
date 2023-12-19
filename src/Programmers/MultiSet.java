package Programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiSet {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int [] result = new int[n];
        int rest = s % n ;
        Arrays.fill(result, s / n);

        for (int i = 0; i < rest; i++) {
            result[i] += 1;
        }

        Arrays.sort(result);
        return result;
    }

    public int[] solution2(int n, int s) {
        if (n > s) return new int[]{-1};
        final int[] result = new int[n];
        //나눈 값 저장
        Arrays.fill(result, s / n);

        // 나머지 값 배열에 순차적 +1
        IntStream.range(0, s % n).forEach(i -> result[i] += 1);

        // 정렬
        Arrays.sort(result);
        return result;
    }
}
