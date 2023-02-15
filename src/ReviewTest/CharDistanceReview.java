package ReviewTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharDistanceReview {
    public static int[] charDistanceList(String str, char c){
        String[] strList = str.split("");
        int count = 10000;
        int []charList = new int[strList.length];
        for(int i=0; i < strList.length; i++){
            if(strList[i].equals(String.valueOf(c))){
                count = 0;
            }
            charList[i] = count++;
        }
        for(int i=strList.length-1; i >= 0; i--){
            if(charList[i]>count)charList[i] = count;
            if(charList[i]==0)count=0;
            count++;
        }
        return charList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        String str = rb.readLine();
        char c = rb.readLine().charAt(0);

        int[] print = charDistanceList(str, c);
        System.out.print("[");
        for(int i=0; i<print.length-1; i++){
            System.out.print(print[i]+",");
        }
        System.out.print(print[charDistanceList(str, c).length-1]+"]");
    }
}
