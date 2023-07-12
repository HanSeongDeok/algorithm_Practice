package neetCode150.TwoPointers;

import java.util.stream.IntStream;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int maxAreaWidth = 0;
        while (leftIndex < rightIndex) {
            int currentArea = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            maxAreaWidth = Math.max(currentArea, maxAreaWidth);
            if (height[leftIndex] < height[rightIndex]) leftIndex ++;
            else rightIndex --;
        }
        return maxAreaWidth;
    }

    //WOW !!!!!
    public int maxArea2(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int heightVar = (Math.min(height[i], height[j]));
            int ta = heightVar*(j - i);
            if (ta > area) area = ta;
            while (height[i] <= heightVar && i < j) i++;
            while (height[j] <= heightVar && i < j) j--;
        }
        return area;
    }
}
