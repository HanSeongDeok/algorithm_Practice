package neetCode150.BinarySearch;

import java.util.Arrays;

public class Find_Minimum_In_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] < nums[r])
                r = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
    public static void main(String[] args) {
        System.out.println(new Find_Minimum_In_Rotated_Sorted_Array().findMin2(new int[]{3,2,1,0,4,5}));
    }
}
