package xiaoyu.algostruct.归类.递归.岛屿数量;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">...</a>
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char val = grid[i][j];
                if (val == '1') {
                    dfs(grid, i, j);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 'p' || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = 'p';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    public static void main(String[] args) {
        int ret = new Solution().numIslands(new char[][]{
                {'1', '1', '0'},
                {'1', '0', '1'},
                {'1', '1', '0'}
        });
        System.out.println(ret);
    }
}
