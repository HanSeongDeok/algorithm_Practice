package softeer.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GBC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = getNums(br);
        int section = nums[0], maxCut = nums[1];
        int max = Integer.MIN_VALUE;

        Map<Integer, int[]> NMs = new HashMap<>();
        for (int i =0; i<section; i++) {
            int[] infos = getNums(br);
            NMs.put(i, infos);
        }

        Map<Integer, int[]> values = new HashMap<>();
        for (int i =0; i<maxCut; i++) {
            int[] infos = getNums(br);
            values.put(i, infos);
        }

        int valueM =  0 , valueV = 0, m = 0, v = 0;
        int i = 0, j = 0;
        while(i < section) {
            m = m == 0 ? NMs.get(i)[0] : m;
            v = v == 0 ? NMs.get(i)[1] : v;

            valueM = valueM == 0 ? values.get(j)[0] : valueM;
            valueV = valueV == 0 ? values.get(j)[1] : valueV;

            if (m < valueM) {
                valueM -= m;
                max = Math.max(max, valueV - v);
                v = 0;      m = 0;
                i++;
            } else {
                m -= valueM;
                max = Math.max(max, valueV - v);
                valueM = 0;     valueV = 0;
                if (m == 0) {
                    v = 0;  i++;
                }
                j++;
            }
        }

        System.out.println(Math.max(max, 0));
    }
    private static int[] getNums(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
