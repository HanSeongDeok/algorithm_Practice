package neetCode150.BinarySearch;

import java.util.Arrays;

public class Koko_Eating_Banana {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().orElseGet(()->0);
        int left = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hour = 0;
            for (int pile : piles){
                int dev = pile / mid;
                hour += dev;
                if (pile % mid !=0 ) hour++;
            }
            if (hour <= h) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public int minEatingSpeed2(int[] piles, int h) {
        int right = Arrays.stream(piles).max().orElseGet(()->0);
        int left = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getHour(piles, mid) <= h) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    private long getHour(int[] piles, int mid) {
        long hour = 0;
        for (int pile : piles) {
            int dev = pile / mid;
            hour += dev;
            if (pile % mid != 0) hour++;
        }
        return hour;
    }

    public static void main(String[] args) {
        //System.out.println("start: " + System.currentTimeMillis());
        System.out.println(new Koko_Eating_Banana().minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000));
        //System.out.println("end: " + System.currentTimeMillis());
    }
}
