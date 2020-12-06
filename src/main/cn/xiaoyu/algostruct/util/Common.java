package xiaoyu.algostruct.util;

import java.util.Random;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/25
 * Desc:
 */

public class Common {
    public static long getTime() {
        return System.currentTimeMillis();
    }

    public static Integer[] initIntArray(int size,int to) {
        Integer array[] = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(to);
        }
        return array;
    }
}
