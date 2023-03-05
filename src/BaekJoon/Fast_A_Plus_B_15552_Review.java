package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Fast_A_Plus_B_15552_Review {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int BUF_SIZE = 122000;
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try(br){
           // br.mark(BUF_SIZE);
            int len = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<len; i++){
                String temp = br.readLine();
                sb.append((Integer.parseInt(temp
                        .substring(0,temp.indexOf(" "))) + Integer.parseInt(temp
                        .substring((temp.indexOf(" ")+1)))+"\n"));
            }
            //br.reset();
            System.out.print(sb);
           // System.out.println(br.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
