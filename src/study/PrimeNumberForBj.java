package study;

import java.io.*;
import java.util.Arrays;

public class PrimeNumberForBj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = Integer.parseInt(br.readLine());
        boolean[] values = new boolean[index +1];
        Arrays.fill(values, true);
        values[0] = false; values[1] = false;

        for (int i = 2; i * i <= index; i++) {
            if (!values[i]) continue;
            for (int j = i * i; j <= index; j+=i) {
                values[j] = false;
            }
        }
        int count = 0;
        for (boolean v : values) {
            if (v) count++;
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}
