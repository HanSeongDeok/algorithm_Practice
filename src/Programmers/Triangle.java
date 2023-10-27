package Programmers;

import java.util.Arrays;

public class Triangle {
    public int solution(int[][] triangle) {
        int[] lastPath = null;
        for (int[] value : triangle)
            lastPath = addValueByPath(value, lastPath);
        return Arrays.stream(lastPath).max().getAsInt();
    }
    private int[] addValueByPath(int[] value, int[] lastPath) {
        if (lastPath == null) return value;
        int prevIndex = 0;
        int[] prevValue = new int[1];
        for (int i = 0; i < value.length; i++) {
            if (i > 1) value[i-1] = Math.max(value[i-1], lastPath[++prevIndex] + prevValue[0]);
            if (i > 0) prevValue[0] = value[i];
            value[i] += lastPath[prevIndex];
        }
        return value;
    }

    public static void main(String[] args) {
        new Triangle().solution(new int[][]{{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}});

    }
}
