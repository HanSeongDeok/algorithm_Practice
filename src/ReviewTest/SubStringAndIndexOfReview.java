package ReviewTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubStringAndIndexOfReview {
    public static void solution(String str){
        String strArr[] = str.split(" ");
        String answer = "";
        int max = 0;
        for (String s: strArr) {
            if(s.length()>max) {
                max = s.length();
                answer = s;
            } else continue;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        String str = rb.readLine();
        solution(str);
    }
}
