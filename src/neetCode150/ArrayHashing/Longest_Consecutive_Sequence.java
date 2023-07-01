package neetCode150.ArrayHashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Longest_Consecutive_Sequence {
    private static int max = 1;
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        final int compareMax[] = new int[]{1};
        final int sortedNums[] = Arrays.stream(nums).distinct().sorted().toArray();
        int max = longestConsecutiveMaxValue(sortedNums, compareMax);
        if (max == 0) return 1;
        return max;
    }
    private static int longestConsecutiveMaxValue(int[] sortedNums, int[] compareMax) {
        return IntStream.range(0, sortedNums.length-1)
                .map(index -> sortedNums[index] + 1 == sortedNums[index+1] ? 1 : 0)
                .map(value -> {
                    if (value == 1) return compareMax[0] += 1;
                    else return compareMax[0] = 1;
                }).max().orElse(0);
    }

    private static int longestConsecutiveMaxValue2(int[] sortedNums, int[] compareMax) {
        return IntStream.range(0, sortedNums.length-1).filter(index -> sortedNums[index] != sortedNums[index+1])
                .map(index -> sortedNums[index] + 1 == sortedNums[index+1] ? 1 : 0)
                .map(value -> {
                    if (value == 1) return compareMax[0] += 1;
                    else return compareMax[0] = 1;
                }).max().getAsInt();
    }



     /* public static int longestConsecutive(int[] nums) {
        if (Optional.ofNullable(nums).isEmpty() || nums.length == 0) return 0;

        final int sortedNums[] = Arrays.stream(nums).sorted().toArray();
        int[] compareMax = new int[1];
        IntStream.range(0, sortedNums.length-1).filter(index -> sortedNums[index] != sortedNums[index+1])
                .forEach(index -> {
             if (sortedNums[index+1] == sortedNums[index]+1) max++;
             else max = 1;
            compareMax[0] = Math.max(max, compareMax[0]);
        });

        if (compareMax[0] == 0) return 1;
        return compareMax[0];
    }*/

   /* private static int longestConsecutiveMaxValue(int[] sortedNums, int[] compareMax) {
        return IntStream.range(0, sortedNums.length-1).filter(index -> sortedNums[index] != sortedNums[index+1])
                .map(index -> {
                    if (sortedNums[index+1] == sortedNums[index]+1) max++;
                    else max = 1;
                    return compareMax[0] = Math.max(max, compareMax[0]);
                }).max().getAsInt();
    }*/

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,1,1,2}));
    }
}
