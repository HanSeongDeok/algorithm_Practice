package LeetCodeReivew;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class productExceptSelfReview {
    public static int[] solution(int[] nums){
        int prefix = 1; // 접두사
        int suffix = 1; // 접미사
        List<Integer> temp = new ArrayList(nums.length);
        for(int i=0; i<nums.length; i++){
            temp.add(prefix);
            prefix *= nums[i];
        }
        for(int i=nums.length-1; i>=0; i--){
            temp.set(i, temp.get(i)*suffix);
            suffix *= nums[i];
        }
        return temp.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try(br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nums[] = IntStream.generate(()->Integer.parseInt(st.nextToken()))
                    .limit(st.countTokens())
                    .toArray();
            bw.write(Arrays.toString(nums)+"\n");
            long startTime = System.nanoTime();
            bw.write(Arrays.toString(solution(nums)));
            long endTime = System.nanoTime();
            System.out.println("Time : " + (endTime - startTime)/1000);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
