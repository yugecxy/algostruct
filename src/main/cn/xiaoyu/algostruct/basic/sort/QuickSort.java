package xiaoyu.algostruct.basic.sort;

public class QuickSort {
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

    /**
     * mark
     */
    public int partition(int[] arr, int begin, int end) {
        int pivotV = arr[end];
        int pivotIdx = begin;
        for (int i = begin; i <= end; i++) {
            if (arr[i] <= pivotV) {
                int tmp = arr[i];
                arr[i] = arr[pivotIdx];
                arr[pivotIdx] = tmp;
                pivotIdx++;
            }
        }
        return pivotIdx - 1;
    }
}
