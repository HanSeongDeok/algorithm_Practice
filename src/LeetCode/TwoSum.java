package LeetCode;

import java.util.*;

public class TwoSum {
    public static int[] solution(int[] nums, int target){
        List<Integer> solution = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i< nums.length; i++) map.put(nums[i], i);
        for(int i=0; i< nums.length; i++){
            if(map.containsKey(target - nums[i])&&i!=map.get(target - nums[i])){
                solution.add(i);
                solution.add(map.get(target-nums[i]));
                return solution.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return null;
    }

    public static int[] solution2(int nums, int target){

        return null;
    }

    public static void main(String[] args) {

    }
}
