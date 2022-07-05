package xiaoyu.algostruct.basic.快排;

import java.util.Arrays;

public class Solution {
    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivotIndex = doSort(arr, begin, end);
        //递左
        quickSort(arr, begin, pivotIndex - 1);
        //递右
        quickSort(arr, pivotIndex + 1, end);
    }

    public int doSort(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] >= pivot) {
                end--;
            }
            arr[begin] = arr[end];
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        //pivot值放界限处
        arr[begin] = pivot;
        return begin;
    }

    public static void main(String[] args) {
        int[] arr = new Solution().quickSort(new int[]{2, 1, 9, 4, 2, 3, 19, 14});
        System.out.println(Arrays.toString(arr));
    }

}
