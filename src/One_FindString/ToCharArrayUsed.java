package One_FindString;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToCharArrayUsed {
    public static void solution (String str){
        String answer;
        char c[] = str.toCharArray(); //문자 char 배열 생성
        int lt=0, rt=c.length-1;
        while (lt<rt) {
            if (!Character.isAlphabetic(c[lt])){
                lt++;
            } else if (!Character.isAlphabetic(c[rt])){
                rt--;
            } else {
                char tmp = c[rt];
                c[rt] = c[lt];
                c[lt] = tmp;
                rt--;
                lt++;
            }
        }
        answer = String.valueOf(c);
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str);
    }
}
