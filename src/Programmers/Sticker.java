package Programmers;

import java.util.Arrays;

public class Sticker {
    /**
     * 오답 노트 -> 첫번째와 두번째가 아닌 세번째 스티커를 바로 땠을 경우를 고려하지 못함..
     * @param sticker
     * @return
     */
    public int solution(int[] sticker) {
        if (sticker.length==1) return sticker[0];
        if (sticker.length==2) return Math.max(sticker[0], sticker[1]);
        // 첫번 째 스티커부터 땠을 경우 최대 값
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0]; dp[1] = sticker[0];
        for (int i=2; i< sticker.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int firstMax = dp[sticker.length-2];

        // 두번 째 스티커부터 땠을 경우 최대 값
        dp = new int[sticker.length];
        dp[0] = sticker[1]; dp[1] = sticker[1];
        for (int i=3; i < sticker.length; i++) {
            dp[i-1] = Math.max(dp[i-2], dp[i-3] + sticker[i]);
        }
        int secondMax = dp[sticker.length-2];

        return Math.max(firstMax, secondMax);
    }

    public int solution2(int[] sticker) {
        if (sticker.length == 1) return sticker[0];
        int []dp = new int[sticker.length+2];

        for (int i = 3; i < dp.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 2]);

        int secondMax = dp[dp.length - 1];

        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 2]);

        int firstMax = dp[dp.length - 2];
        return Math.max(firstMax, secondMax);
    }

    public static void main(String[] args) {
        new Sticker().solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
    }
}
