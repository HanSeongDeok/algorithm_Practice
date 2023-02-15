package LeetCode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomUseByForEach {

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  public static boolean canAttendingMeeting(Interval[] intervals){
        // 값이 음수면 그대로, 양수면 교환 하는 정렬
      Arrays.sort(intervals, (o1, o2) -> o1.start - o2.start);
      Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1.start, o2.start)); // 위와 똑같음

      Interval interval = null;
      //forEach 로 첫번째와 나머지 수행 나누는 플래그 설정방법 공간 복잡도 O(2n)/ 시간 복잡도 O(n))
      for(Interval i : intervals){
          if(interval != null && interval.end>i.start){
              return false;
          }
          interval = i;
      }
      // for 문으로 플래그 설정 공간 복잡도 O(2n)/ 시간 복잡도 O(n))
      for(int i =0; i<intervals.length; i++){
          if(i!=0 && interval.end > intervals[i].start){
              return false;
          }
          interval = intervals[i];
      }
      // 2번째 방법 (공간 복잡도(O(n)) / 시간 복잡도(O(n)))
      for(int i=0; i<intervals.length-1; i++){
          if(intervals[i].end > intervals[i+1].start){
              return false;
          }
      }
      return true;
  }
    // another Method
    public static boolean canAttendMeetingRoom2 (Interval[] i){
        Arrays.sort(i, (o1, o2) -> Integer.compare(o1.start,o2.start));
        for(int x =0; x<i.length-1;x++){
            if(i[x].end > i[x+1].start){
                return false;
            }
        }
        return true;
    }

    public static boolean canAttendUseThrows(Interval[] intervals){
        Arrays.sort(intervals, new AttendIntervalComparator());
        Interval temp = null;
        for(Interval i : intervals){
            if(temp != null && temp.end > i.start){
                return false;
            }
            temp = i;
        }
        return true;
    }

    private static class AttendIntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public static void main(String[] args) {
        Interval[] interval = {new MeetingRoomUseByForEach.Interval(0,30),
                new MeetingRoomUseByForEach.Interval(5,10),
                new MeetingRoomUseByForEach.Interval(15,20)};
        System.out.println(canAttendingMeeting(interval));
        System.out.println(canAttendMeetingRoom2(interval));
        System.out.println(canAttendUseThrows(interval));
    }
}
