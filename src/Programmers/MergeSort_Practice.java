package Programmers;

import java.util.Arrays;

public class MergeSort_Practice {
    public int[] mergeSort(int []arr) {
        if (arr.length < 2) return arr;
        int middle = arr.length / 2;

        int leftInts[] = mergeSort(Arrays.copyOfRange(arr, 0, middle));
        int rightInts[] = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));

        return merge(leftInts, rightInts);
    }
    private int[] merge(int[] leftInts, int [] rightInts){
        return null;
    }
}
