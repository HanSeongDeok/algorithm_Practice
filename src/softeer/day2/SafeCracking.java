package softeer.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SafeCracking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] wn = getWNandMP(br);
        List<int[]> lists = new ArrayList<>(wn[1]);

        for (int i = 0; i < wn[1]; i++) {
            int[] mp = getWNandMP(br);
            lists.add(mp);
        }

        lists = lists.stream()
                .sorted((o1, o2) -> o2[1] - o1[1])
                .collect(Collectors.toList());

        int total = wn[0], value = 0, index = 0;
        while (total > 0) {
            int[] nums = lists.get(index++);
            if (nums[0] >= total) {
                value += total * nums[1];
                break;
            }
            total -= nums[0];
            value += nums[0] * nums[1];
        }
        System.out.println(value);
    }

    private static int[] getWNandMP(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

