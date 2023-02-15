package LeetCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRoom {
    public class Interval {
        Integer start;
        Integer end;
        Interval(Integer s, Integer e){
            this.start = s; this.end =e;
        }
        public String toString(){
            return String.valueOf(this.start);
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {

        return false;
    }
        public static void main(String[] args) {
            MeetingRoom.Interval test = new MeetingRoom().new Interval(1,1);
            MeetingRoom.Interval test2 = new MeetingRoom().new Interval(2,2);
            MeetingRoom.Interval test3 = new MeetingRoom().new Interval(3,3);

            MeetingRoom.Interval[] testArr = {test,test2,test3};
            Arrays.sort(testArr, (a, b)-> a.start-b.start);

            for (int i=0; i <testArr.length; i++){
                System.out.println(testArr[i]);
            }

            System.out.println(testArr[0] + " " + testArr[1] + " " + testArr[2]);
    }
}
