package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NotGoalInPlayer {
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        Map map = new HashMap();
        for (int i = 0; i < participant.length; i++) map.put(i, participant[i]);
        for (int i = 0; i < completion.length; i++) {
            if (!map.get(i).equals(completion[i])) return (String) map.get(i);
        }
        return (String) map.get(participant.length - 1);
    }

    public static String solution2(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i])-1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()!=0) return entry.getKey();
        }
        return "";
    }

    public static void main(String[] args) {
        String participant[] = {"leo", "kiki", "eden"};
        String completion[] = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
        System.out.println(solution2(participant, completion));
    }
}
