package softeer.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SecretMenu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = getNums(br);
        int[] N = getNums(br);
        int[] M = getNums(br);

        int max = 0; int count=0;

        for (int i =0; i< N.length; i++) {
            max = getSequenceMaxLen(max, i, M, N, count);
        }
        System.out.println(max);
    }
    private static int getSequenceMaxLen(int max, int i, int[] M, int[] N, int count){
        if (count == N.length - i) return max;
        String a = "";
        for (int j = count; j < count+i+1; j++){
            a += N[j]+",";
        }
        for (int k=0; k < M.length - i; k++) {
            String b = "";
            for (int j = k; j < k + i +1; j++) {
                b+=M[j]+",";
            }
            if (a.contains(b)) return i+1;
        }
        return getSequenceMaxLen(max, i, M, N, ++count);
    }
    private static int[] getNums(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
