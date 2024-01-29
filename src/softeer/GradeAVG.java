package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GradeAVG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums1 = Arrays.stream(br.readLine().split(" "))
                                            .mapToInt(Integer::parseInt)
                                            .toArray();

        int[] num2 = Arrays.stream(br.readLine().split(" "))
                                            .mapToInt(Integer::parseInt)
                                            .toArray();

        String[] result = new String [nums1[1]];
        double add = 0;
        for (int i=0; i < nums1[1]; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                                            .mapToInt(Integer::parseInt)
                                            .toArray();

            for (int j=nums[0]-1; j <= nums[1]-1; j++) {
                add += num2[j];
            }
            add = add / (nums[1] - nums[0] + 1);
            result[i] = String.format("%.2f", add);
            add=0;
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}
