package xiaoyu.algostruct.basic.归并;

class Solution {
    public int[] merge(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        //伪代码
        int[] left = new int[]{};
        int[] right = new int[]{};
        return mergeSort(merge(left), merge(right));
    }

    public int[] mergeSort(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] ret = new int[a.length + b.length];
        int k = 0;
        while (i < a.length || j < a.length) {
            if (j >= b.length || (i < a.length && a[i] < b[j])) {
                ret[k] = a[i];
                i += 1;
            } else {
                ret[k] = b[j];
                j += 1;
            }
            k += 1;
        }
        return ret;
    }
}
