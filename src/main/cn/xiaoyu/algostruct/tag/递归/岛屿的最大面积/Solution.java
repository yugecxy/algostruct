package xiaoyu.algostruct.tag.递归.岛屿的最大面积;

/**
 * <a href="https://leetcode.cn/problems/ZL6zAn/">...</a>
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        return dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + 1;
    }

    public static void main(String[] args) {
        int ret = new Solution().maxAreaOfIsland(
                new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
        );
        System.out.println(ret);
    }
}
