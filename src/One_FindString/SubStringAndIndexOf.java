package One_FindString;

import java.io.*;
import java.util.Arrays;

/**
 * 문장 속 단어
 */
public class SubStringAndIndexOf {
    /**
     * split 활용
     * @param str
     */
    public static void solution(String str){
        String answer = "";
        String [] s = str.split(" ");
        int max = 0;
        for (String str2 : s) {
            int len = str2.length();
            if (len>max){
                answer = str2;
                max=len;
            } else continue;
        }
        System.out.println(answer);
    }

    /**
     * IndexOf 활용
     * @param str
     */
    public static void solution2(String str) {
        String answer = "";
        int m=0, len;
        while ((len=str.indexOf(" "))!=-1){
            int max = str.substring(0,len).length();
            if(max > m){
                m = max;
                answer = str.substring(0,len);
            }
            str = str.substring(len+1);
        }
        if(str.length()>answer.length()) answer = str;
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        //solution(str);
        solution2(str);
        /*bw.write(str);
        bw.flush();
        bw.close();*/
    }
}
