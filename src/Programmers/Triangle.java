package Programmers;

public class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[] lastPath = null;
        for (int[] value : triangle){
            lastPath = addValueByPath(value, lastPath);
        }
        return answer;
    }

    //TODO 내일 하기!!
    private int[] addValueByPath(int[] value, int[] lastPath) {
        if (lastPath == null) return value;
        int prevIndex = 0;
        int[] prevValue = new int[1];
        for (int i = 0; i < value.length; i++) {
            if (i > 0) prevValue[0] = value[i];
            if (i > 0 && i%2 == 0) {
                prevIndex++;
                value[i] += lastPath[prevIndex];
                value[i-1] = Math.max(value[i-1], lastPath[prevIndex] + prevValue[0]);
            }

        }
        return value;
    }
}
