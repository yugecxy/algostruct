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
        int pivotIndex = partition(arr, begin, end);
        //递左
        quickSort(arr, begin, pivotIndex - 1);
        //递右
        quickSort(arr, pivotIndex + 1, end);
    }

    public int partition(int[] arr, int begin, int end) {
        int i = begin;
        int j = begin;
        int pivotVal = arr[end];
        while (j <= end) {
            if (arr[j] <= pivotVal) {
                //swap
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
            j++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, 8, 5};
//        new Solution().doSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(new Solution().quickSort(arr)));
    }

}
