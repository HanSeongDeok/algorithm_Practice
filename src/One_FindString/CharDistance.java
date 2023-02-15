package One_FindString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharDistance {
    public static int[] solution(String[] strList, char c){
        int target = 1001;
        int []solutionList = new int [strList.length];
        for(int i = 0; i < strList.length; i++){
            if(strList[i].equals(String.valueOf(c))) {
                target = 0;
            }
            solutionList[i] = target;
            target++;
        }
        target = solutionList[strList.length-1];
        for(int i = solutionList.length-1; i>=0; i--){
            if(solutionList[i] == 0) {
                target=0;
            }else {
                target++;
                solutionList[i] = Math.min(solutionList[i],target);
            }
        }
        return solutionList;
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            char c = br.readLine().charAt(0);
            String []strList = str.split("");
            for(int print : solution(strList, c)){
                System.out.print(print + " ");
            }
        }catch (Exception e){
            System.out.println("NOPE");
        }
    }
}
