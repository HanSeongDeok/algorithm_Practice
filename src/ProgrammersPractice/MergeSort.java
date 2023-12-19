package ProgrammersPractice;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] forSortArr){
        int middle = forSortArr.length / 2;
        if (middle < 1) return forSortArr;
        int[] leftSortArr = mergeSort(Arrays.copyOfRange(forSortArr, 0, middle));
        int[] rightSortArr = mergeSort(Arrays.copyOfRange(forSortArr, middle, forSortArr.length));
        int lIndex = 0, rIndex = 0, sArrIndex = 0;
        int[] sortedArr = new int[forSortArr.length];
        while (lIndex < leftSortArr.length && rIndex < rightSortArr.length) {
            if (leftSortArr[lIndex] > rightSortArr[rIndex]) sortedArr[sArrIndex++] = rightSortArr[rIndex++];
            else sortedArr[sArrIndex++] = leftSortArr[lIndex++];
            }
        while (lIndex < leftSortArr.length) {
            sortedArr[sArrIndex++] = leftSortArr[lIndex++];
        }
        while (rIndex < rightSortArr.length) {
            sortedArr[sArrIndex++] = rightSortArr[rIndex++];
        }
        return sortedArr;
    }
}

