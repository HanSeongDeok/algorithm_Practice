package neetCode150.TwoPointers;

public class Trapping_Rain_Water {
    public static int trap(int[] height) {
        int left = 0, leftMax = height[left], right = height.length-1, rightMax = height[right];
        int water = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left ++;
                if (leftMax < height[left]) leftMax = height[left];
                else water += leftMax - height[left];
            } else {
                right --;
                if (rightMax < height[right]) rightMax = height[right];
                else water += rightMax - height[right];
            }
        }
        return water;
    }

    public static int trap2(int[] height) {
        int left = 0, leftMax = height[left], right = height.length-1, rightMax = height[right];
        int water = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            water += (leftMax < rightMax) ? leftMax - height[left++] : rightMax - height[right--];
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
