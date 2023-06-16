package xiaoyu.algostruct.tag.递归.机器人的运动范围;

/**
 * <a href="https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/">...</a>
 */
public class Solution {
    boolean[][] arr;

    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }
        arr = new boolean[m][n];
        return dfs(0, 0, k, arr);
    }

    public int dfs(int x, int y, int k, boolean[][] arr) {
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y]) {
            return 0;
        }
        if ((x / 10 + x % 10 + y / 10 + y % 10) > k) {
            return 0;
        }

        arr[x][y] = true;
        return dfs(x - 1, y, k, arr) + dfs(x + 1, y, k, arr) + dfs(x, y + 1, k, arr) + dfs(x, y - 1, k, arr) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(11, 8, 16));
    }

}
