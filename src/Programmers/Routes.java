package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Routes {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int count = 1, advancePoint = routes[0][1];
        for (int i=1; i<routes.length; i++) {
            if (advancePoint < routes[i][0]) {
                count++;
                advancePoint = routes[i][1];
            }
        }
        return count;
    }
}
