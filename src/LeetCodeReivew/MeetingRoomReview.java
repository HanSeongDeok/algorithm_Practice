package LeetCodeReivew;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomReview {
    Interval2 interval2;
    private static class Interval2{
        int startTime;
        int endTime;
        Interval2 next;
        Interval2(int startTime, int endTime, Interval2 next){
            this.startTime = startTime;
            this.endTime = endTime;
            this.next = next;
        }
    }
    public static boolean solution(Interval2[] interval2s){
        Arrays.sort(interval2s, ((o1, o2) -> o1.startTime - o2.startTime));
        Interval2 temp = null;
        for(Interval2 i : interval2s){
            if(temp != null && temp.endTime > i.startTime) return false;
            temp = i;
        }
        return true;
    }
    public static void main(String[] args) {
        int [][]meetingTimeList = {{0,11},{10,20},{25, 40}};
        Interval2 interval2List[] = new Interval2[meetingTimeList.length];
        Interval2 temp = null;
        for(int i=0; i < meetingTimeList.length; i++){
            temp = new Interval2(meetingTimeList[i][0],meetingTimeList[i][1],temp);
            interval2List[i] = temp;
        }
        System.out.println(solution(interval2List));

    }
}
