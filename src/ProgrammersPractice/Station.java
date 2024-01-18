package ProgrammersPractice;

import java.util.Arrays;

public class Station {
    public int solution(int n, int[] stations, int w) {
        int begin = 1, count = 0;
        for (int s : stations) {
            int end = s - w, possLen = end - begin;
            if (possLen > 0) count = calCount(w, count, possLen);
            begin = s + w + 1;
        }
        if (begin <= n) {
            int end = n + 1, possLen = end - begin;
            count = calCount(w, count, possLen);
        }
        return count;
    }

    private int calCount(int w, int count, int possLen) {
        int result = possLen / (2 * w + 1);
        boolean isRest = possLen % (2 * w + 1) > 0;
        if (isRest) count++;
        count += result;
        return count;
    }

    private int calCount(StationRecord record) {
        return record.calCount();
    }
}
