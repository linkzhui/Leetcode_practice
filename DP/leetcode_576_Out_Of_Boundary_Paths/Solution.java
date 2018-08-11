package Google.DP.leetcode_576_Out_Of_Boundary_Paths;

//这道题给了我们一个二维的数组，某个位置放个足球，每次可以在上下左右四个方向中任意移动一步，总共可以移动N步，
// 问我们总共能有多少种移动方法能把足球移除边界，由于结果可能是个巨大的数，所以让我们对一个大数取余。
// 那么我们知道对于这种结果很大的数如果用递归解法很容易爆栈，所以最好考虑使用DP来解。
// 那么我们使用一个三维的DP数组，其中dp[k][i][j]表示总共走k步，从(i,j)位置走出边界的总路径数。
// 那么我们来找递推式，对于dp[k][i][j]，走k步出边界的总路径数等于其周围四个位置的走k-1步出边界的总路径数之和，
// 如果周围某个位置已经出边界了，那么就直接加上1，否则就在dp数组中找出该值，这样整个更新下来，
// 我们就能得出每一个位置走任意步数的出界路径数了，最后只要返回dp[N][i][j]就是所求结果了

//dp[k][i][j] = dp[k-1][i][j]

//因为dp[n][i][j]only depend on dp[n-1][i][j]，
//therefore we can use 2D array to store partial result.
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(m<0||n<0||i<0||j<0||N<0)
        {
            return 0;
        }

        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int count = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] d : dirs) {
                        int cur_x = x + d[0];
                        int cur_y = y + d[1];
                        if (cur_x < 0 || cur_x >= m || cur_y < 0 || cur_y >= n) {
                            count = (count + dp[x][y]) % MOD;
                        }
                        else {
                            temp[cur_x][cur_y] = (temp[cur_x][cur_y] + dp[x][y]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }

        return count;
    }
}
