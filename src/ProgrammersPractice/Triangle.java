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

    public int solution2(int[][] triangle) {
        int prevArr[] = null;
        for (int i[] : triangle) {
            prevArr = addPathArr(i, prevArr);
        }
        return Arrays.stream(prevArr).max().getAsInt();
    }
    private int[] addPathArr(int []i, int[] prevArr){
        if (prevArr == null) return i;
        int pIndex = 0;
        int originValue = 0;
        for (int k = 0; k < i.length; k++) {
            if (k > 1) i[k-1] = Math.max(i[k-1], originValue + prevArr[++pIndex]);
            originValue = i[k];
            i[k] = prevArr[pIndex] + originValue;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().solution2(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
