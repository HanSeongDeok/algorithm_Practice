package neetCode150.ArrayHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Product_Of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> prefixMap = new HashMap(nums.length);
        Map<Integer, Integer> suffixMap = new HashMap(nums.length);
        int [] solution = new int[nums.length];

        IntStream.range(0, nums.length).filter(value -> {
            if (value == 0) prefixMap.put(value, 1);
            return value != 0;
        }).forEach(value -> prefixMap.put(value, prefixMap.get(value-1) * nums[value-1]));

        IntStream.range(0, nums.length).filter(value -> {
            if (value == 0) suffixMap.put(value, 1);
            return value !=0;
        }).forEach(value -> suffixMap.put(value, suffixMap.get(value-1) * nums[nums.length - value]));

        IntStream.range(0, nums.length)
                .forEach(value -> solution[value] = prefixMap.get(value) * suffixMap.get(nums.length-1 - value));
        return solution;
    }

    public int[] productExceptSelf2(int[] nums) {
        Map<Integer, Integer> prefixMap = new HashMap();
        Map<Integer, Integer> suffixMap = new HashMap();

        IntStream.range(0, nums.length).filter(index -> {
            if (index == 0) prefixMap.put(index, 1);
            return index!=0;
        }).forEach(index -> prefixMap.put(index, nums[index-1]*prefixMap.get(index-1)));

        IntStream.iterate(nums.length-1, index -> index>=0, index -> index-1).filter(index -> {
            if (index == nums.length-1) suffixMap.put(index, 1);
            return index!=nums.length-1;
        }).forEach(index -> suffixMap.put(index, nums[index+1] * suffixMap.get(index+1)));

        return IntStream.range(0, nums.length).map(index -> prefixMap.get(index) * suffixMap.get(index)).toArray();
    }

    public static void main(String[] args) {
        int [] test = {1,2,3,4};
        int[] good =  new Product_Of_Array_Except_Self().productExceptSelf2(test);
    }
}
