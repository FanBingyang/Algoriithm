package LeetCode.JianZhiOffer.DFS;

/**
 * @Author: FBY
 * @Date: 2021/4/29 16:36
 * @Version 1.0
 */

/**
 * 题目描述
 * 地上有一个 m 行 n 列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格 [35, 37] ，因为 3+5+3+7=18。但它不能进入方格 [35, 38]，因为 3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1:
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2:
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class MovingCount {
    /**
     * 思路
     * ·标签：dfs
     * ·整体思路：
     *      从原点出发，沿四个方向（本题中两个方向就行了，因为可行区域在原点的右下方）不断拓展，
     *      将可到达并且满足坐标数位和不大于 k 的点加入到队列中，直到所有可到达的点都被访问到。
     * ·复杂度：
     *      ·时间复杂度：O(mn)。
     *      ·空间复杂度：O(mn)。
     * 算法流程
     * 1.递归参数：当前元素在矩阵中的行列索引 i 和 j，是否被访问的标记，矩阵的行列长度
     * 2.终止条件：
     *  ·行列索引越界
     *  ·数位和大于 k
     *  ·已被访问过
     * 3.递推:
     *  ·标记当前元素已被访问
     *  ·计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归
     */
    public int movingCount(int m,int n,int k){
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    public int dfs(int i,int j,int m,int n,int k,boolean visited[][]){
        if (i<0 || i>=m || j<0 || j>=n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return dfs(i+1,j,m,n,k,visited) + dfs(i,j+1,m,n,k,visited) + 1;
    }
}
