package softeer.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AplusB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        int[] nums = new int[i];

        for (int k = 0; k < i; k++) {
            String[] adds = br.readLine().split(" ");
            nums[k] = Integer.parseInt(adds[0]) + Integer.parseInt(adds[1]);
        }

        for (int k=0; k<i; k++) {
            System.out.println("Case #"+k+1+": " + nums[k]);
        }
    }
}
