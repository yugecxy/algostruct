package xiaoyu.algostruct.tag.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <a href="https://leetcode.cn/problems/climbing-stairs/">...</a>
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                f[i] = 1;
            } else if (i == 1) {
                f[i] = 2;
            } else {
                f[i] = f[i - 1] + f[i - 2];
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(1));
    }
}
