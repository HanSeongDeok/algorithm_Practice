package One_FindString;

import java.io.*;

public class convertUpperCaseLetter {
    /**
     * @implNote ASCII NUMBER = 대문자 : 65~90, 소문자 : 97~122
     * @param str
     * @return
     */
    public static String solution(String str){
        String answer = "";
        for (char x : str.toCharArray()) {
            //answer+=(Character.isLowerCase(x))? Character.toUpperCase(x) : Character.toLowerCase(x);
            /** ASCII CODE로 풀이 */
            answer+=(x>=65&&x<=90)? (char)(x+32) : (char)(x-32);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write(str+"\n");
        bw.flush();

        System.out.println(solution(str));
        bw.close();
    }
}
