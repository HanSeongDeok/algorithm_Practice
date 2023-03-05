package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductOfArrayExceptSelf {
    public static int[] solution(int nums[]){
        int prefix = 1;
        int suffix = 1;
        int []solution = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            solution[i] = prefix;
            prefix *= nums[i];
        }
        for(int i=nums.length-1; i>=0; i--){
            solution[i] *= suffix;
            suffix *= nums[i];
        }
        return solution;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        //int nums[] = {-1,1,0,-3,3};
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(solution(nums)));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
    }
}
