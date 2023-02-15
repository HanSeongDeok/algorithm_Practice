package One_FindString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 숫자만 추출해내는 문제
 */
public class ExtractionOnlyNumber {
    public static void solution(String str) {
        int answer = 0;
        for (char x: str.toCharArray())
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        System.out.println(answer);
    }
    public static void solution2(String str){
        String answer="";
        for(char c : str.toCharArray())
            if (Character.isDigit(c)) {
                answer += c;
            }
        System.out.println(Integer.valueOf(answer));
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str);
    }
}
