package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {
    // 매개변수가 List 로 넘어오는지 배열로 넘어오는지 몰라서..
    public int solution(List<Integer> integers) {
        // 만약 배열로 넘어올 시 아래 코드로 리스트 만들어서 사용
        // -> Arrays.stream(integers).boxed().collect(Collectors.toList());
        return (int) integers.stream()
                .filter(this::isPrimeNumber)
                .filter(this::isPalindrome)
                .count();
    }
    private boolean isPalindrome(Integer i) {
        String s = String.valueOf(i);
        String substring = s.substring(0, s.length() / 2);
        String es1 = s.substring(s.length() / 2);
        String es2 = s.substring(s.length() / 2 + 1);

        if(s.length() < 2) return false;
        else if(s.length() % 2 == 0 && substring.equals(es1)) return true;
        else if(s.length() % 2 != 0 && substring.equals(es2)) return true;
        return false;
    }
    private boolean isPrimeNumber(int i) {
        for (int k = 2; k <= i/2; k++) {
            if (i % k == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.stream(new int[]{2, 11, 131})
                .boxed()
                .collect(Collectors.toList());

        System.out.println(new Palindrome().solution(a));
    }
}
