package neetCode150.ArrayHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    private static boolean checkingDuplicate;
    public static boolean solution(int [] nums) {
        Set set = new HashSet();
        Arrays.stream(nums).forEach(v -> {
            if (set.contains(v)) checkingDuplicate = true;
            set.add(v);
        });
        return checkingDuplicate;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(solution(nums));
    }
}
