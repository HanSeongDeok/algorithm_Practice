package neetCode150.BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class Search_In_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (end + start)/2;
            if (target == nums[mid]) return mid;
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) end = mid-1;
                else start = mid + 1;
            }
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
}