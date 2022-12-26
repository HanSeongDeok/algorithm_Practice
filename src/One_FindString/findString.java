package One_FindString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class findString {
    public static int solution(String str, char t){
        int answer=0;
        str=str.toUpperCase();
        t=Character.toUpperCase(t);

       // System.out.println(str + " " + t);
       /* for(int i=0; i < str.length(); i++){
            if(str.charAt(i)==t){
                answer++;
            }
        }*/

        for(char x : str.toCharArray()){
            if(x==t) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = reader.readLine();
            char c = reader.readLine().charAt(0);
            System.out.println(solution(str, c));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       /* Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        char b = scanner.next().charAt(0);
        System.out.println(solution(a,b));*/
    }
}
