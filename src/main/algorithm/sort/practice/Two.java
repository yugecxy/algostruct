package algorithm.sort.practice;

/**
 * desc：2个有序数组，找2个数组合并的第K大数字
 */
public class Two {
    //归并排序思路
    public static int getValue(int[] a, int[] b, int k) {
        int i = a.length - 1;
        int j = b.length - 1;
        int sta = 0;
        int tmp = 0;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                tmp = a[i--];
            } else {
                tmp = b[j--];
            }
            if (sta++ == k) {
                break;
            }
        }
        while (i >= 0) {
            tmp = a[i--];
            if (sta++ == k) break;
        }
        while (j >= 0) {
            tmp = b[j--];
            if (sta++ == k) break;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(getValue(new int[]{1, 2, 2, 8}, new int[]{6}, 3));
    }
}
