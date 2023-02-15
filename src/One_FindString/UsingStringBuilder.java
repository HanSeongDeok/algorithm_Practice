package One_FindString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UsingStringBuilder {
    public static void solution(int n, String[] strArr){
        ArrayList answer = new ArrayList();
        for (String x: strArr) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        answer.forEach(System.out::println);
    }

    public static void solution2(int n, String[] strArr){
        ArrayList answer = new ArrayList();
        for (String x: strArr) {
            char[] s = x.toCharArray();
            int lt=0,rt=x.length()-1;
            while (lt<rt){
                char tmp=s[lt];
                s[lt++] = s[rt];
                s[rt--] = tmp;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        answer.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.valueOf(br.readLine());
        String strArr[] = new String[len];
        for(int i=0; i<len; i++){
            strArr[i] = br.readLine();
        }
        solution2(len, strArr);
    }
}
