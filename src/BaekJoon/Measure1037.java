package BaekJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Measure1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(nums);    rpq.addAll(nums);

        System.out.println(pq.element() * rpq.element());
    }
}
