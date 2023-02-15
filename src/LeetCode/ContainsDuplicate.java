package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean solution(int[] a){
        Set set = new HashSet();
        for(int i=0; i<a.length;i++){
            if(set.contains(a[i])){
                return true;
            }
            set.add(a[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        System.out.println(solution(a));
    }
}
