package xiaoyu.algostruct;

public class Test {
    private int ret;

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


    public void dfs(int[] arr, int begin, int end, int k) {
        int pivotIndex = doQuick(arr, begin, end);
        int dist = arr.length - pivotIndex;
        if (dist == k) {
            ret = arr[pivotIndex];
        } else if (dist > k) {
            dfs(arr, pivotIndex + 1, end, k);
        } else {
            dfs(arr, begin, pivotIndex - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 7, 8, 6, 2, 1};
//        int[] arr2 = new int[]{6,8,7};
//        new Test().doQuick(arr2,0,2);
        Test t = new Test();
        t.dfs(arr, 0, 7, 8);
        System.out.println(t.ret);
    }
}
