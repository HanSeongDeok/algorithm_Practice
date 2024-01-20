package study;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean check = false;
        int i = Integer.parseInt(br.readLine());
        while (!check) {
            if (!isPrimeNumber(i) || !isPalindrome(i)) {
                i++;
            } else check = true;
        }
        bw.write(String.valueOf(i));

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
        for (int n = 2; n <= i / 2; n++) {
            if (i % n == 0) return false;
        }
        return true;
    }
    public static boolean isPrimeNumber2(int i) {
        if (i < 2) return false;
        for (int n = 2; n * n <= i; n ++) {
            if (i % n == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(int i) {
        String s = String.valueOf(i);
        if (s.length() == 1) return true;

        String es = (s.length()%2 == 0) ?
                s.substring(s.length() / 2) :
                s.substring(s.length() / 2 + 1);
        String v = s.substring(0, s.length() / 2);

        return v.equals(new StringBuffer(es).reverse().toString());
    }
}
