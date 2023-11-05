package ProgrammersPractice;

import java.util.Arrays;

public class Triangle {
    public int solution(int[][] triangle) {
        int prevRows[] = null;
        for (int []rows : triangle){
            prevRows = maxValue(rows, prevRows);
        }
        return Arrays.stream(prevRows).max().getAsInt();
    }
    private int[] maxValue(int[] rows, int[] prevRows) {
        if (prevRows == null) return rows;
        int temp = 0, prevIndex = 0;
        for (int i=0; i < rows.length; i++) {
            if (i>1) rows[i-1] = Math.max(rows[i-1], prevRows[++prevIndex]+temp);
            temp = rows[i];
            rows[i] += prevRows[prevIndex];
        }
        return rows;
    }

    public static void main(String[] args) {
        new Triangle().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }
}
