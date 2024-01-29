package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ArraySum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine().split(" ")[1]);

        int[] nums = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        int max = 0; int count = 0; int add = 0;
        for (int i=0; i< nums.length; i++) {
            while (count < index) {
                add += nums[i + count++];
            }
            if (max < add) max = add;
            add = 0;
            count = 0;
            if (i + index >= nums.length) break;
        }
        System.out.println(max);
    }
}
