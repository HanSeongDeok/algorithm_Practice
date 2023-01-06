package One_FindString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Deduplicate {
    public static void solution (String str){
        StringBuilder answer = new StringBuilder();
        for (int i =0; i<str.length(); i++){
            if (str.indexOf(str.charAt(i))==i){
                answer.append(str.charAt(i));
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str);
    }
}
