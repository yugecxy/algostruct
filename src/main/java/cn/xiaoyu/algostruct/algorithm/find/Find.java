package cn.xiaoyu.algostruct.algorithm.find;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/25
 * Desc: 查找
 */
public class Find {
    /**
     * @param array 有序数组
     * @param start 数组低地址下标
     * @param end   数组高地址下标
     * @param key   查找元素
     * @return 查找元素不存在返回-1
     * @desc 二分查找（递归思想）
     * 时间复杂度：O(logn)
     */
    public static int binSearch(int[] array, int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (start > end) {
            return -1;
        }
        if (array[mid] == key) {
            return mid;
        } else if (key > array[mid]) {
            return binSearch(array, mid + 1, end, key);
        } else {
            return binSearch(array, start, mid - 1, key);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1, 9};
        int result = binSearch(array, 0, array.length - 1, 6);
        System.out.println(result);
    }
}
