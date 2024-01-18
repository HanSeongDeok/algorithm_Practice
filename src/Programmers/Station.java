package Programmers;

public class Station {
    public int solution(int n, int[] stations, int w) {
        int begin = 1, count = 0;
        for (int station : stations) {
            int leftEnd = station - w;
            if (leftEnd > begin) {
                int posLen = leftEnd - begin;
                count = getCount(w, count, posLen);
            }
            begin = station + w + 1;
        }
        if (begin <= n) {
            int posLen = (n + 1) - begin;
            count = getCount(w, count, posLen);
        }
        return count;
    }
    private int getCount(int w, int count, int posLen) {
        int result = posLen / (2 * w + 1), rest = posLen % (2 * w + 1);
        if (rest > 0) count++;
        return count += result;
    }

    public static void main(String[] args) {
        new Station().solution(16, new int[]{9}, 2);
    }
}
