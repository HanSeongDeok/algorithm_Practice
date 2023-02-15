package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidAnagram {
    public static boolean solution(String s, String t){
        Set set = new HashSet();
        for(int i=0; i < s.length(); i++) set.add(s.charAt(i));
        for(int i=0; i < t.length(); i++){
            if(!set.contains(t.charAt(i)) && s.length()!=t.length()){
                return false;
            }
        }
        return true;
    }

    public static boolean solution2(String s, String t){
        char []list1 = s.toCharArray();
        char []list2 = t.toCharArray();

        Arrays.sort(list1);
        Arrays.sort(list2);

        String check1 = new String(list1);
        String check2 = new String(list2);
        return check1.equals(check2);
    }
    public static void main(String[] args) {

    }
}
