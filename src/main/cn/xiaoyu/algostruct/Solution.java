package xiaoyu.algostruct;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;

import xiaoyu.algostruct.helper.TreeNode;

public class Solution {
    public int partition(int[] arr, int begin, int end) {
        int i = begin;
        int j = begin;
        int pivot = arr[end];
        while (j <= end) {
            if (arr[j] <= pivot) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
            j++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
    }
}
