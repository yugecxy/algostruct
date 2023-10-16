package xiaoyu.algostruct.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <a href="https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/">...</a>
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] arr = new boolean[m][n];
        int cnt = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 && y == 0 && getSumBySplit(x) + getSumBySplit(y) <= k) {
                    cnt += 1;
                    arr[x][y] = true;
                    continue;
                }
                boolean left = x - 1 >= 0 && arr[x - 1][y];
                boolean right = x + 1 < m && arr[x + 1][y];
                boolean up = y + 1 < n && arr[x][y + 1];
                boolean down = y - 1 >= 0 && arr[x][y - 1];
                boolean cur = (left || up || right || down) && getSumBySplit(x) + getSumBySplit(y) <= k;
                if (cur) {
                    cnt += 1;
                    arr[x][y] = true;
                }
            }
        }
        return cnt;
    }

    public int wardrobeFinishing(int m, int n, int cnt) {
        boolean[][] arr = new boolean[m][n];
        int num = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 && y == 0 && getSumBySplit(x) + getSumBySplit(y) <= cnt) {
                    num += 1;
                    arr[x][y] = true;
                    continue;
                }
                boolean left = x - 1 >= 0 && arr[x - 1][y];
                boolean up = y - 1 >= 0 && arr[x][y - 1];
                boolean cur = (left || up) && getSumBySplit(x) + getSumBySplit(y) <= cnt;
                if (cur) {
                    num += 1;
                    arr[x][y] = true;
                } else {
                    System.out.println(x + "," + y);
                }
            }
        }
        return num;
    }


    public int getSumBySplit(int num) {
        int sum = 0;
        for (Character i : String.valueOf(num).toCharArray()) {
            sum += Integer.parseInt(i.toString());
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new MovingCount().wardrobeFinishing(3, 5, 4));
    }
}
