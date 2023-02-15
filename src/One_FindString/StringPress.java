package One_FindString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StringPress {
    public static String solution(String strList){
        String solution= new StringBuilder().toString();
        strList = strList + " ";
        int count = 1;
        for(int i=0; i< strList.length()-1; i++){
            if(strList.charAt(i)==strList.charAt(i+1)){
                count++;
            } else {
                solution += strList.charAt(i);
                if(count>1) solution += count;
                count=1;
            }
        }

        return solution;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        String str = rb.readLine().toUpperCase();
        System.out.println(solution(str));
    }
}
