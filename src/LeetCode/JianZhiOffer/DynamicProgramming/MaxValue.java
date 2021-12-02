package LeetCode.JianZhiOffer.DynamicProgramming;

/**
 * @Author: FBY
 * @Date: 2021/4/26 11:21
 * @Version 1.0
 */

/**
 * 题目描述
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class MaxValue {
    /**
     * 思路
     * ·标签：动态规划
     * ·整体思路：在遍历二维数组时，通过状态转移方程计算出当前位置的最大价值，同时通过复用入参来减少空间复杂度
     * ·时间复杂度：O(m*n)，空间复杂度：O(1)
     * 算法流程
     * 1.初始化行数 row 和列数 column，遍历二维数组进行动态规划
     * 2.状态定义：状态转移二维数组为 dp，dp[i][j] 表示从 grid[0][0] 到 grid[i][j] 得到礼物的最大价值
     * 3.动态转移方程：
     *  ·当 i=0 && j=0 时，dp[0][0] = grid[0][0]
     *  ·当 i=0 && j!=0 时，dp[i][j] = grid[i][j] + dp[i][j-1]
     *  ·当 i!=0 && j=0 时，dp[i][j] = grid[i][j] + dp[i-1][j]
     *  ·当 i!=0 && j!=0 时，dp[i][j] = grid[i][j] + max(dp[i-1][j], dp[i][j-1])
     * 4.初始状态：dp[0][0] = grid[0][0]
     * 5.结果值：dp[row-1][column-1]，row 为二维数组行数，column 为二维数组列数
     * 6.空间上因为 dp 与 grid 大小一致，可以使用 grid 空间作为 dp 空间，减少空间复杂度
     */
    public int maxValue(int[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if(i==0 && j==0){
                    continue;
                }else if (i==0){
                    grid[i][j] += grid[i][j-1];
                }else if (j==0){
                    grid[i][j] += grid[i-1][j];
                }else {
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[row-1][column-1];
    }

    /**
     *
     */
    public static int MyMaxValue(int[][] grid){
        return core(grid,0,0);
    }

    public static int core(int[][] grid,int i,int j){
        int m = grid.length;;
        int n = grid[0].length;
        if (i>=m || j>=n)
            return 0;
        if (i==m-1 && j==n-1)
            return grid[i][j];
        int r = core(grid,i,j+1);
        int d = core(grid,i+1,j);
        return Math.max(r,d) + grid[i][j];
    }
}
