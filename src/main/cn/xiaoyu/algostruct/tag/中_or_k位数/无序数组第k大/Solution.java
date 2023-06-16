package xiaoyu.algostruct.tag.中_or_k位数.无序数组第k大;

/**
 * 时间复杂度：n+n/2+n/4+n/8+...+1 = 2n-1，也就是O(n)
 */
public class Solution {
    public int doQuick(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] > pivot) {
                end--;
            }
            arr[begin] = arr[end];
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        int pivotIndex = begin;
        arr[pivotIndex] = pivot;
        return pivotIndex;
    }


    public int dfs(int[] arr, int begin, int end, int k) {
        int pivotIndex = doQuick(arr, begin, end);
        int dist = arr.length - pivotIndex;
        if (dist == k) {
            return arr[pivotIndex];
        } else if (dist > k) {
            return dfs(arr, pivotIndex + 1, end, k);
        } else {
            return dfs(arr, begin, pivotIndex - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 7, 8, 6, 2, 1};
        Solution t = new Solution();
        System.out.println(t.dfs(arr, 0, 7, 3));
    }
}
