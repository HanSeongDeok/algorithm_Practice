package Programmers;

import java.util.Arrays;

public class MergeSort_Practice {
    public int[] mergeSort(int []arr) {
        if (arr.length < 2) return arr;
        int middle = arr.length / 2;
        int leftInts[] = mergeSort(Arrays.copyOfRange(arr, 0, middle));
        int rightInts[] = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));
        return merge(leftInts, rightInts, arr.length);
    }
    private int[] merge(int[] leftInts, int [] rightInts, int arrSize){
        int l=0, r=0, m=0;
        int[] mergeArr = new int[arrSize];
        while (l < leftInts.length && r < rightInts.length){
            if (leftInts[l] < rightInts[r]) mergeArr[m++] = leftInts[l++];
            else if(leftInts[l] >= rightInts[r]) mergeArr[m++] = rightInts[r++];
        }
        while (l <= leftInts.length) {
            mergeArr[m++] = leftInts[l++];
        }
        while (r <= rightInts.length){
            mergeArr[m++] = rightInts[r++];
        }
        return mergeArr;
    }
    public int[] oldMergeSort(int []arr, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int middle = (endIndex + startIndex) / 2;
            oldMergeSort(arr, startIndex, middle);
            oldMergeSort(arr, middle+1, endIndex);
            oldMerge(arr, startIndex, middle, endIndex);
        }
        return arr;
    }
    private void oldMerge(int[] arr, int startIndex, int middle, int endIndex) {
        int l = startIndex, r = middle+1, count = 0;
        int[] mergeArr = new int[endIndex-startIndex+1];
        while (l <= middle && r <= endIndex) {
            if (arr[l] < arr[r]) mergeArr[count++] = arr[l++];
            else if (arr[l] >= arr[r]) mergeArr[count++] = arr[r++];
        }
        while (l <= middle) {
            mergeArr[count++] = arr[l++];
        }
        while (r <= endIndex) {
            mergeArr[count++] = arr[r++];
        }
        for (int i=0; i < mergeArr.length; i++) {
            arr[startIndex + i] = mergeArr[i];
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{38, 27, 43, 3, 9, 82, 10};
        int result[] = new MergeSort_Practice().oldMergeSort(test, 0, test.length-1);
        System.out.println(Arrays.toString(result));
    }
}
