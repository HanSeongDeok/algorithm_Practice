package ReviewTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @implNote 문자열 찾기 Review
 */
public class findStringReview {
    public static void solution(String str, char c){
        int answer = 0;
        for (char c1: str.toUpperCase().toCharArray()) {
            answer += (Character.toUpperCase(c) == c1)? 1 : 0;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = br.readLine().charAt(0);
        solution(str, c);
    }
}
