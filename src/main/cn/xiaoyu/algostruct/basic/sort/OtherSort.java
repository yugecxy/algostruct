package xiaoyu.algostruct.basic.sort;

import java.util.Arrays;

public class OtherSort {
    public void bub(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minV = arr[i];
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minV) {
                    minV = arr[j];
                    minI = j;
                }
            }
            int tmp = arr[i];
            arr[i] = minV;
            arr[minI] = tmp;
        }
    }

    public void insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    //swap
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 8, 2, 5, 1};
        new OtherSort().insert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
