package xiaoyu.algostruct.leetcode;

/**
 * <a href="https://leetcode.cn/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c = 0;
        int i = 0;
        while (i < flowerbed.length && c < n) {
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (flowerbed[i] == 0 && left && right) {
                flowerbed[i] = 1;
                c++;
            }
            i++;
        }
        return c == n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0, 1, 0, 1, 0, 0, 0};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 3));
    }
}
