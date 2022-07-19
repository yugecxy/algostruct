package xiaoyu.algostruct.归类.递归.单词搜索;

/**
 * <a href="https://leetcode.cn/problems/word-search/">...</a>
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word, int trace) {
        if (trace == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '/' || board[row][col] != word.charAt(trace)) {
            return false;
        }

        char tmp = board[row][col];
        board[row][col] = '/';
        boolean ret = dfs(board, row + 1, col, word, trace + 1) || dfs(board, row - 1, col, word, trace + 1) || dfs(board, row, col + 1, word, trace + 1) || dfs(board, row, col - 1, word, trace + 1);
        board[row][col] = tmp;
        return ret;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'s', 'b', 'm'}, {'s', 'o', 'k'}, {'r', 'a', 'k'}, {'d', 'o', 'l'},};
        char[][] board2 = new char[][]{
                {'b'},
                {'a'},
                {'b'},
                {'b'},
                {'a'}
        };
        System.out.println(new Solution().exist(board2, "ab"));
    }
}
