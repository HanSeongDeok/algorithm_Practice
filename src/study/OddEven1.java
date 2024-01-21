package study;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddEven1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(br.readLine());
        int[] nums = new int[index];
        for (int i=0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.stream(nums)
                .mapToObj(OddEven1::oddOrEven)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    public static String oddOrEven(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return (count % 2 == 0) ? "Even" : "Odd";
    }
}
