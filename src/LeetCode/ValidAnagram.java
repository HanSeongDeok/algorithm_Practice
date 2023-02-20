package LeetCode;

import java.util.*;

public class ValidAnagram {
    public static boolean solution(String s, String t){
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }
        for(Integer check : map.values()){
            if(check != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean solution3(String s, String t){
        if(s.length()!= t.length()) return false;
        Map map = new HashMap();
        for(int i=0; i < s.length(); i++){
            map.put(s.charAt(i), (Integer)map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i =0; i<t.length(); i++){
            map.put(t.charAt(i), (Integer)map.getOrDefault(t.charAt(i), -1)-1);
        }
        for (int i=0; i<map.size(); i++){
            if((Integer) map.get(s.charAt(i))!=0){
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
