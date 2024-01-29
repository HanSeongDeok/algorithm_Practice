package study;

import java.io.*;
import java.util.*;

public class ParenthesisStringForBj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for(char c : chars) queue.add(c);

        int count = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (count == 0 && c == ')') {
                count--; break;
            }
            else if (c == ')') count--;
            else if (c == '(') count ++;
        }
        bw.write(count == 0 ? "YES" : "NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
