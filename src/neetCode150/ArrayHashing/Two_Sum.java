package neetCode150.ArrayHashing;

import java.util.*;
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

    /**
     * @NOTE 오답노트 - map 에 value 로 key 값을 찾는게 불가능하다는 사실을 망각해버림
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int [] twoNums = new int[2];

        IntStream.range(0, nums.length).forEach(value -> map.put(nums[value], value));
        return IntStream.range(0, nums.length)
                .filter(value -> map.containsKey(target - nums[value]))
                .filter(value -> value != map.get(target - nums[value]))
                .mapToObj(value -> {
                    twoNums[0] = value;
                    twoNums[1] = map.get(target - nums[value]);
                    return twoNums;
                }).findFirst().orElse(new int[0]);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
}
