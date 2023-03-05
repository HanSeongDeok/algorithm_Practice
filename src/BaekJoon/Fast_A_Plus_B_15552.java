package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Fast_A_Plus_B_15552 {
    public static void main(String[] args) throws IOException {
        final int BUFF_SIZE = 262144;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //br.mark(BUFF_SIZE);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "abser";
        bw.write(s+"\n" + Integer.toBinaryString(Integer.parseInt(br.readLine()))+"\n");
        bw.flush();
        //bw.close();
        //br.reset();
        long startNanoTime = System.nanoTime();
        System.out.println("================== solution ================== ");
        //br = new BufferedReader(new InputStreamReader(System.in));
        //bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<len; i++){
            st = new StringTokenizer(br.readLine());
            //br.reset();
            bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())+"\n");
        }
        long endNanoTime = System.nanoTime();
        System.out.println("Time : " + (endNanoTime - startNanoTime)/1000000000);
        br.close();
        bw.flush();
        bw.close();


    }
}
