package neetCode150.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        IntStream.range(0, numbers.length).forEach(index -> map.put(numbers[index], index));

        return IntStream.range(0, numbers.length)
                .filter(index -> map.containsKey(target - numbers[index]))
                .filter(index -> index != map.get(target - numbers[index]))
                .mapToObj(index -> {
                    int [] twoSumNum = new int [2];
                    twoSumNum[0] = index;
                    twoSumNum[1] = map.get(target - numbers[index]);
                    return twoSumNum;
                }).findFirst().orElse(new int[0]);
    }

    public static int[] twoSum2(int[] numbers, int target) {
        // 자바에서 제공하는 이진 탐색 메서드
        return IntStream.range(1, numbers.length)
                .filter(index -> Arrays.binarySearch(numbers, 0, index, target - numbers[index]) >= 0)
                .mapToObj(index -> new int[]{Arrays.binarySearch(numbers, 0, index, target - numbers[index])+1, index+1})
                .findFirst().orElseGet(() -> new int[0]);
    }


    public static void main(String[] args) {
        int[] test = twoSum2(new int[]{2,3,4}, 6);
    }
}
