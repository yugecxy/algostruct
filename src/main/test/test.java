package test;

import algorithm.sort.Sort;
import util.Common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/5/2
 * Desc:
 */
public class test {

    public static Integer[] yu(Integer[] array) {
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
        return array;
    }

    public static void main(String[] args) {
//        Stream.of(yu(Common.initIntArray(10,100))).forEach(System.out::println);
        Integer[] arr = Common.initIntArray(50000, 100000);
        System.out.println("开始计算");
        long begin = Common.getTime();
        yu(arr);
        long end = Common.getTime();
        System.out.println((end - begin) / 1000);
    }
}
