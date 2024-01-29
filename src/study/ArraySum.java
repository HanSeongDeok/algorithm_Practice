package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine().split(" ")[1]);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .toList();

        int count = 0; int sum = 0;
        for (int i : list) {
            sum += i;
            if (sum >= M) {
                if (sum == M) count++;
                sum = i;
            }
        }
        System.out.println(count);
    }
}
