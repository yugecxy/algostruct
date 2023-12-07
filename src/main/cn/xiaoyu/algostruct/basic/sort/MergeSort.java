package xiaoyu.algostruct.basic.sort;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int pivot = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, pivot);
        int[] arr2 = Arrays.copyOfRange(arr, pivot, arr.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    public int[] merge(int[] a, int[] b) {
        int[] ret = new int[a.length + b.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < a.length || j < b.length) {
            if (j >= b.length || (i < a.length && a[i] <= b[j])) {
                ret[index] = a[i];
                i++;
            } else {
                ret[index] = b[j];
                j++;
            }
            index++;
        }
        return ret;
    }
}
