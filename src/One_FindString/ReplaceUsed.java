package One_FindString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 정규식 활용 회문 Check
 */
public class ReplaceUsed {
    public static void solution(String str) {
        String answer = "";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        answer = (tmp.equalsIgnoreCase(str))? "Yes" : "No";
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        String str = rb.readLine();
        solution(str);
    }
}
