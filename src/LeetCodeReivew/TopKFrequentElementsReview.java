package LeetCodeReivew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TopKFrequentElementsReview {
    public static int[] solution(int[] nums, int k){
        Map<Integer, List<Integer>> map = new HashMap();
        List<Integer> valueTemp = new ArrayList();
        int[] solution = new int[k];
        for (int i=0; i<nums.length; i++){
            if(map.get(nums[i])!=null){
                List<Integer> temp = map.get(nums[i]);
                temp.add(nums[i]);
            } else {
                List<Integer> temp = new ArrayList(nums[i]);
                temp.add(nums[i]);
                map.put(nums[i], temp);
            }
        }
        for(List<Integer> temp : map.values().stream()
                .sorted((o1, o2) -> o2.size()- o1.size())
                .toList()){
            valueTemp.add(temp.get(0));
        }
        solution = valueTemp.stream().mapToInt(Integer::intValue).limit(k).toArray();
        return solution;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 2;
        try(br){
            StringTokenizer st = new StringTokenizer(br.readLine());
          int nums[] = IntStream.generate(()->Integer.parseInt(st.nextToken()))
                  .limit(st.countTokens())
                  .toArray();
            System.out.println(Arrays.toString(nums));
            solution(nums, k);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
