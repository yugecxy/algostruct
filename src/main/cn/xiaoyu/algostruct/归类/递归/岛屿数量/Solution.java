package xiaoyu.algostruct.归类.递归.岛屿数量;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">...</a>
 */
public class Solution {
    int min = 999999999;

    public void dfs(int[][] grid, int i, int j, int prevValue, int acc) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == -1) {
            return;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            min = Math.min(acc, min);
        }

        int cur = grid[i][j];
        int abs = Math.abs(cur - prevValue);
        grid[i][j] = -1;
        dfs(grid, i, j + 1, cur, acc + abs);
        dfs(grid, i, j - 1, cur, acc + abs);
        dfs(grid, i + 1, j, cur, acc + abs);
        dfs(grid, i - 1, j, cur, acc + abs);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {1, 2, 3},
                {3, 4, 5},
                {1, 1, 1}
        };
        solution.dfs(grid, 0, 0, 0, 0);
        System.out.println(solution.min);
    }
}
