package algorithm.sort.practice;

import algorithm.sort.Sort;
import util.Common;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/8/9
 * Desc: 对两个已经排序好的数组排序
 */
public class One {
    //归并排序的思路
    public static Integer[] merge(Integer[] array1, Integer[] array2) {
        Integer[] arr = new Integer[array1.length + array2.length];
        int i = 0, j = 0, k = 0;  //i:用于标识array1数组    j：用来标识array2数组  k：用来标识传入的数组
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                arr[k++] = array1[i++];
            } else {
                arr[k++] = array2[j++];
            }
        }
        //保证两个数组比较完之后剩下的一个数组里的元素能顺利传入
        while (i < array1.length) {
            arr[k++] = array1[i++];
        }
        while (j < array2.length) {
            arr[k++] = array2[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        long begin1 = Common.getTime();
        Integer[] a = Common.initIntArray(1000000, 100000);
        long end1 = Common.getTime();
        System.out.println(end1 - begin1);
        Integer[] b = Common.initIntArray(1000000, 100000);
        new Sort().quickSort(a);
        new Sort().quickSort(b);
        long begin = Common.getTime();
        merge(a, b);
        long end = Common.getTime();
        System.out.println(end - begin);
//        Stream.of(arr).forEach(System.out::println);
    }
}
