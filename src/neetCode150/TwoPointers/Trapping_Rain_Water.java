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

    public static int trap3(int[] height) {
       int left = 0, right = height.length-1, water = 0, leftMax = 0, rightMax = 0;
       while (left < right) {
           leftMax = Math.max(leftMax, height[left]);
           rightMax = Math.max(rightMax, height[right]);
           water += (leftMax <= rightMax) ? leftMax - height[left++] : rightMax - height[right--];
       }
        return water;
    }

    //TODO STACK 구조체를 이용하여 풀이도 해보기
    public static int trap4(int[] height) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,1,2,1,2,1}));
        System.out.println(trap3(new int[]{0,1,0,2,1,0,1,1,2,1,2,1}));
    }
}
