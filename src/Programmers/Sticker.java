package Programmers;

import java.util.Arrays;

public class Sticker {
    public int solution(int[] sticker) {
        if (sticker.length==1) return sticker[0];
        // 첫번 째 스티커부터 땠을 경우 최대 값
        int[] dp = new int[sticker.length-1];
        dp[0] = sticker[0]; dp[1] = sticker[0];
        for (int i=2; i< sticker.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int firstMax = dp[sticker.length-2];

        // 두번 째 스티커부터 땠을 경우 최대 값
        dp = new int[sticker.length-1];
        dp[0] = sticker[1]; dp[1] = sticker[1];
        for (int i=3; i < sticker.length; i++) {
            dp[i-1] = Math.max(dp[i-2], dp[i-3] + sticker[i]);
        }
        int secondMax = dp[sticker.length-2];

        return Math.max(firstMax, secondMax);
    }

    public static void main(String[] args) {
        new Sticker().solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
    }
}
