package study;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GCDAndGCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = gcd(nums[0], nums[1]);
        int b = lcm(nums[0] * nums[1], a);

        bw.append(String.valueOf(a))
                .append("\n")
                .append(String.valueOf(b));
        br.close();
        bw.flush();
        bw.close();
    }
    private static int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }
    private static int lcm(int a, int b){
        return a / b;
    }
}
