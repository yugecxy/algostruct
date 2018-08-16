package algorithm.sort;

import util.Common;

import java.util.*;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/25
 * Desc: 排序（参考：https://github.com/francistao/LearningNotes/blob/master/Part3/Algorithm/Sort/%E9%9D%A2%E8%AF%95%E4%B8%AD%E7%9A%84%2010%20%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93.md
 */
public class Sort {
    /**
     * @param array
     * @desc 冒泡排序：两两交换(20000个数36s左右)
     * 时间复杂度：O(n^2)
     */
    public void bubble(Integer[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
    }

    /**
     * @param array
     * @desc 选择排序：对比冒泡减少了交换的次数，选择仅仅是两个数交换(100000个数21s左右)
     * 时间复杂度：O(n^2)
     */
    public void select(Integer[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int max = i;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            int tmp = array[max];
            array[max] = array[i];
            array[i] = tmp;
        }
    }

    /**
     * @param array
     * @desc 插入排序(100000个数4s左右)
     * 时间复杂度：O(n^2)
     */
    public void insertSort(Integer[] array) {
        for (int i = 1; i < array.length; i++)      //待插入的
        {
            int insert = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > insert) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = insert;
                    break;
                }
            }
        }
    }

    /**
     * @param array
     * @desc 希尔排序(100000个数4s左右)
     * 时间复杂度：O(n^1.3)
     */
    public void ShellSort(Integer[] array) {
        for (int i = 1; i < array.length; i++)      //待插入的
        {
            int insert = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > insert) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = insert;
                    break;
                }
            }
        }
    }

    /**
     * @param
     * @desc 归并排序(100, 000个数49ms左右, 1000, 000个数415ms)
     * 时间复杂度：O(nlogn)
     */
    public void merge(Integer[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    public void mergeSort(Integer[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
        }

    }

    /**
     * @desc 计数排序
     */

    public static void countSort(Integer[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int help[] = new int[max];

        //找出每个数字出现的次数
        for(int i = 0; i < arr.length; i++){
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        int index = 0;
        for(int i = 0; i < help.length; i++){
            while(help[i]-- > 0){
                arr[index++] = i+min;
            }
        }
    }

    /**
     * @param
     * @desc 桶排序(1000, 000个数450ms左右)
     * 时间复杂度：桶排序的平均时间复杂度为线性的O(N+C)，其中C=N*(logN-logM)。
     * 如果相对于同样的N，桶数量M越大，其效率越高，最好的时间复杂度达到O(N)。
     * 当然桶排序的空间复杂度 为O(N+M)，如果输入数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的
     */
    public void bucketSort(Integer[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        //计算出桶的个数
        int bucketSize = (max - min) / array.length + 1;
        System.out.println("桶的个数是:" + bucketSize);
        List<LinkedList<Integer>> bucket = new ArrayList();
        //初始化桶（每个桶里面装的是链表）
        for (int i = 0; i < bucketSize; i++) {
            bucket.add(new LinkedList<>());
        }
        for (int i = 0; i < array.length; i++) {
            //计算数组元素的桶值
            int index = (array[i] - min) / (array.length);
            bucket.get(index).add(array[i]);
        }
        //桶内部使用快速排序
        for (int i = 0; i < bucketSize; i++) {
            Collections.sort(bucket.get(i));
        }
        int k = 0;
        for (List<Integer> bu : bucket) {
            for (int ele : bu) {
                array[k++] = ele;
            }
        }
    }

    /**
     * @param
     * @desc 快速排序(1000, 000个数400ms左右)
     * 时间复杂度：O(nlgn)
     *
     */
    public void quickSort(Integer[] array) {
        List<Integer> list=new LinkedList();   //链表比数组效率要高
        for(Integer i:array){
            list.add(array[i]);
        }
        Collections.sort(list);
    }

    public static void main(String[] args) {
        Integer[] arr = Common.initIntArray(10, 1000);
        System.out.println("开始计算");
        long begin = Common.getTime();
        new Sort().mergeSort(arr,0,arr.length-1);

        long end = Common.getTime();
        System.out.println(end - begin);
//        Stream.of(arr).forEach(System.out::println);
    }
}
