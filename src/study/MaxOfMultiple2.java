package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxOfMultiple2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine());


        long[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long s = System.currentTimeMillis();
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(Arrays.stream(nums).boxed().toList());

        System.out.println(pq.poll() * pq.poll());
        long e = System.currentTimeMillis();
        System.out.println((e - s) / 1000 + " sec");
    }
}
