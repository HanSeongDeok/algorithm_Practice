package neetCode150.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class Maximum_Window_Substring {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] r = new int[nums.length-k+1];
        int rIndex = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int index = 0; index < nums.length; index++) {
            while (!q.isEmpty() && q.peek() <= index - k) q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[index]) q.pollLast();
            q.offer(index);
            if (index > k - 2) r[rIndex++] = nums[q.peek()];
        }
        return r;
    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (k <= 0 || nums == null) return new int[0];
        int winArr[] = new int[nums.length - k + 1];
        int winArrIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<nums.length; i++) {
            if (!deque.isEmpty() && i - deque.peek() >= k) deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i > k-2) winArr[winArrIndex++] = nums[deque.peek()];
        }
        return winArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
