package neetCode150.ArrayHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Two_Sum {
    private static int index = 0;
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] sums = new int[2];
        Arrays.stream(nums).forEach(v -> map.put(v, index++));
        IntStream.range(0,nums.length)
                .filter(i -> map.containsKey(target - nums[i]) && i != map.get(target-nums[i]))
                .findFirst()
                .ifPresent(i -> {
                    sums[0] = i;
                    sums[1] = map.get(target - nums[i]);
                });
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
