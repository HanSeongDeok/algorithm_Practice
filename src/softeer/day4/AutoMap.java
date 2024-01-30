package softeer.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AutoMap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 2;
        int seq = 1;
        for (int i=1; i<=N; i++) {
            seq = (i==1) ? 1 : seq * 2;
            num += seq;
        }
        System.out.println(num * num);
    }
}
