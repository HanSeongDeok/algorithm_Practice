package study;

import java.io.*;
import java.util.Arrays;

public class PalindromeForBJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int index = Integer.parseInt(br.readLine());
        int[] numbers = new int[index];
        
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(Arrays.stream(numbers)
                .filter(PalindromeForBJ::isPrimeNumber)
                .filter(PalindromeForBJ::isPalindrome)
                .count()));

        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean isPalindrome(int i) {
        char[] chars = String.valueOf(i).toCharArray();
        int s = 0, e = chars.length-1;
        while (s < e) {
            if (chars[s++] != chars[e--]) return false;
        }
        return true;
    }
    public static boolean isPrimeNumber(int i) {
        if (i < 2) return false;
        for (int n = 2; n <= i/2; n++) {
            if (i %n == 0) return false;
        }
        return true;
    }
}
