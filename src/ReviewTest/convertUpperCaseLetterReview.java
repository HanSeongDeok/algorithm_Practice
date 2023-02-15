package ReviewTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @implNote 대소문자 변환 Review
 */
public class convertUpperCaseLetterReview {
    public static void solution(String str){
        String answer="";
        for(char c : str.toCharArray()){
            answer += (c==Character.toUpperCase(c))? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
        System.out.println(answer);
    }
    public static void solution2(String str){

    }
    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        String str = rb.readLine();
        solution(str);
    }
}
