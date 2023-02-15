package ReviewTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UsingStringBuilderReview {
    public static void solution(String[] strArr){
        ArrayList<String> strList = new ArrayList();
        for(String s : strArr){
            strList.add(new StringBuilder(s).reverse().toString());
        }
        strList.forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        int strLen = Integer.valueOf(rb.readLine());
        String strArr[]=new String[strLen];
        for (int i=0; i<strLen; i++) {
            strArr[i] = rb.readLine();
        }
        solution(strArr);
    }
}
