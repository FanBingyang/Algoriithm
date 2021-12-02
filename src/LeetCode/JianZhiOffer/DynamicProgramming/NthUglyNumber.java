package LeetCode.JianZhiOffer.DynamicProgramming;

/**
 * @Author: FBY
 * @Date: 2021/4/26 16:26
 * @Version 1.0
 */

/**
 * 题目描述
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:
 * 1 是丑数。
 * n 不超过 1690。
 */
public class NthUglyNumber {
    /**
     * 思路
     * ·标签：动态规划
     * ·整体思路：
     *      ·除了第一个丑数外，所有的丑数都是某一个丑数的 2、3 或 5 倍的数字
     *      ·因为要从小到大求第 n 个丑数，所以需要按照顺序每次获取下一个最小的丑数，最终获得第 n 个
     * ·复杂度：
     *      ·时间复杂度：O(n)。只需要 n 次遍历即可求得第 n 个丑数
     *      ·空间复杂度：O(n)。需要保存动态规划的整体状态数组
     * 算法流程
     * 1.状态定义： dp[n] 表示第 n 个丑数，a 表示 2 倍数字的索引用于 dp[a]*2,b 表示 3 倍数字的索引用于 dp[b]*3,c 表示 5 倍数字的索引用于 dp[c]*5
     * 2.转移方程：
     *  ·dp[n] = min(dp[a]*2, dp[b]*3, dp[c]*5)dp[n]=min(dp[a]∗2,dp[b]∗3,dp[c]∗5)
     *  ·每次计算之后，如果 2 倍的数字最小，则 a++，如果 3 倍的数字最小，则 b++，如果 5 倍的数字最小，则 c++
     * 3.初始状态： dp[0]=1，因为第一个丑数是 1
     */
    public static int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] dp =new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2){
                a++;
            }
            if (dp[i] == n3){
                b++;
            }
            if (dp[i] == n5){
                c++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
