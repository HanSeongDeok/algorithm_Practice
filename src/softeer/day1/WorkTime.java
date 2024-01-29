package softeer.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class WorkTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hTotal = 0, mTotal = 0;
        for (int i=0; i<5; i++) {
            String[] w = br.readLine().split(" ");
            hTotal +=
                            Integer.parseInt(w[1].substring(0,2)) -
                            Integer.parseInt(w[0].substring(0,2));

            mTotal +=
                            Integer.parseInt(w[1].substring(3)) -
                            Integer.parseInt(w[0].substring(3));
        }
        System.out.println(hTotal * 60 + mTotal);
    }
}
