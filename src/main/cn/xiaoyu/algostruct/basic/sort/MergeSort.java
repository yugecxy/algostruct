package xiaoyu.algostruct.basic.sort;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int pivotIndex = (arr.length - 1) / 2;
        int[] left = Arrays.copyOfRange(arr, 0, pivotIndex + 1);
        int[] right = Arrays.copyOfRange(arr, pivotIndex + 1, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (j >= arr2.length || (i < arr1.length && arr1[i] < arr2[j])) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }
        return merged;
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 9, 8};
        int[] arr1 = {5, 6, 7};
        int[] arr2 = {8, 9};
    }
}
