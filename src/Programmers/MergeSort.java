package Programmers;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{38, 27, 43, 3, 9, 82, 10};
        //new MergeSort().mergeSort(arr, 0,arr.length-1);
        arr = new MergeSort().mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middle = (endIndex + startIndex) / 2;
            // left
            mergeSort(arr, startIndex, middle);
            //right
            mergeSort(arr, middle+1, endIndex);
            // merge
            merge(arr, startIndex, middle, endIndex);
        }
    }

    private void merge(int[] arr, int startIndex,int middle ,int endIndex){
        int[] temp = new int[endIndex - startIndex + 1];
        int leftStart = startIndex;
        int rightStart = middle + 1;
        int tempIndex = 0;

        while (leftStart <= middle && rightStart <= endIndex) {
            if (arr[leftStart] >= arr[rightStart]) temp[tempIndex] = arr[rightStart++];
            else if (arr[leftStart] < arr[rightStart]) temp[tempIndex] = arr[leftStart++];
            tempIndex++;
        }

        while (leftStart <= middle) {
            temp[tempIndex++] = arr[leftStart++];
        }

        while (rightStart <= endIndex) {
            temp[tempIndex++] = arr[rightStart++];
        }

        for (int i=0; i < temp.length; i++) {
            arr[startIndex + i] = temp[i];
        }
    }
    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] low_arr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] high_arr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] mergedArr = new int[arr.length];
        int m = 0, l = 0, h = 0;
        while (l < low_arr.length && h < high_arr.length) {
            if (low_arr[l] < high_arr[h])
                mergedArr[m++] = low_arr[l++];
            else
                mergedArr[m++] = high_arr[h++];
        }
        while (l < low_arr.length) {
            mergedArr[m++] = low_arr[l++];
        }
        while (h < high_arr.length) {
            mergedArr[m++] = high_arr[h++];
        }
        return mergedArr;
    }
}
