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

        int pivot = begin;
        int pivotVal = arr[pivot];
        for (int i = begin + 1; i <= end; i++) {
            if (arr[i] < pivotVal) {
                int tmp = arr[i];
                for (int j = i; j > pivot; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[pivot] = tmp;
                pivot += 1;
            }
        }

        //递左
        quickSort(arr, begin, pivot - 1);

        //递右
        quickSort(arr, pivot + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new Solution().quickSort(new int[]{2, 1, 9, 4, 2, 3, 19, 14});
        System.out.println(Arrays.toString(arr));
    }

}
