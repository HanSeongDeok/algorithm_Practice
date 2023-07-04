package neetCode150.TwoPointers;

import One_FindString.MinimumDistance;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        Set<List<Integer>> temp = new HashSet();
        return IntStream.range(0, sortedNums.length)
                .mapToObj(i -> {
                    int j = i + 1;
                    return IntStream.range(j, sortedNums.length-1)
                            .filter(index -> nums[i] + nums[index]  == 0)
                            .mapToObj(index -> Arrays.asList(nums[i], nums[j], nums[index]))
                            .filter(integers -> temp.add(integers.stream().sorted().collect(Collectors.toList())))
                            .collect(Collectors.toList());
                }).flatMap(lists -> lists.stream()).collect(Collectors.toList());
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        List<Integer> temp = new ArrayList<>();

        return  IntStream.range(0,nums.length).mapToObj(index -> {
            int j = index + 1;
            int k = nums.length - 1;
            int[] up = new int[1];
            int[] down = new int[1];
            return IntStream.range(j+up[0], k+down[0]).mapToObj(index2 -> {
                int sum = nums[index2] + nums[j] + nums[k];
                if (sum == 0) {
                    up[0]++;
                    down[0]--;
                    return Arrays.asList(nums[index2], nums[j], nums[k]);
                } else if (sum < 0) {
                    up[0]++;
                }else {
                    down[0]--;
                }
                return temp;
            }).collect(Collectors.toList());
        }).flatMap(lists -> lists.stream()).collect(Collectors.toList());
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        IntStream.range(0, nums.length).forEach(index -> {
          int i = index + 1;
          int j = nums.length - 1;
          while (i < j) {
              if (nums[index] + nums[i] + nums[j] == 0) {
                  set.add(Arrays.asList(nums[index], nums[i], nums[j]));
                  i++;
                  j--;
              } else if (nums[index] + nums[i] + nums[j] < 0) i++;
              else j--;
          }
      });
      return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<List<Integer>>test = threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
