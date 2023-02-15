package One_FindString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 회문 문자열 찾기 문제 palindrome
 */
public class Palindrome {
    public static void solution(String str){
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for (int i =0; i< len/2; i++){
            if (str.charAt(i)==str.charAt((str.length()-1)-i)){
                continue;
            } else {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

    public static void solution2(String str) {
        String answer = "";
        String sbStr = new StringBuilder(str).reverse().toString();
        answer = (str.equalsIgnoreCase(sbStr))? "YES" : "NO";
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution2(str);
    }
}
