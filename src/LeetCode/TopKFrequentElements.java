package LeetCode;

import java.util.*;
import java.util.stream.Stream;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, List<Integer>> map = new HashMap();
        List<Integer> solutionTemp = new ArrayList();
        int [] solution = new int[k];
        for(int i=0; i< nums.length; i++){
            if(map.get(nums[i])!=null) {
                List<Integer> temp = map.get(nums[i]);
                temp.add(nums[i]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                map.put(nums[i], temp);
            }
        }
        for(List<Integer> temp : map.values().stream()
                .sorted((o1, o2) -> o2.size()- o1.size())
                .toList()){
            solutionTemp.add(temp.get(0));
        }
        for(int i=0; i<k; i++){
            solution[i] = solutionTemp.get(i);
        }
        return solution;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
