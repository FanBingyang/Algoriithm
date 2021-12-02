package LeetCode.JianZhiOffer.DynamicProgramming;

/**
 * @Author: FBY
 * @Date: 2021/4/24 22:13
 * @Version 1.0
 */

/**
 * 题目描述
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 提示：
 * 0 <= n <= 100
 */
public class NumWays {

    /**
     * 思路
     * ·标签：动态规划
     * ·整体思路：本质是斐波那契数列和循环求余法
     *      ·令 F(n)F(n) 表示为上第 nn 层台阶时所需要的跳法
     *      ·因为一次可以跳上 1 级台阶，也可以跳上 2 级台阶，所以 F(n)F(n) 可以从 F(n-1)F(n−1) 跳上来，也可以从 F(n-2)F(n−2) 跳上来
     *      ·推导出 F(n) = F(n-1) + F(n-2)F(n)=F(n−1)+F(n−2)
     *      ·由于第 nn 层的跳法数量只取决于 n-1n−1 和 n-2n−2 层，所以存储时，可以仅存储这三个值，优化空间复杂度
     * ·时间复杂度：O(n)，空间复杂度：O(1)
     * 算法流程
     * 1.围绕斐波那契数列方程 F(n) = F(n-1) + F(n−2)F(n)=F(n−1)+F(n−2) 进行解题，所以在求 n 元素时，只需要知道第 n-1 和 n-2 个元素即可
     *  ·状态定义： F[n] 表示的含义为斐波那契数列中第 n 个数字
     *  ·转移方程： F(n) = F(n-1) + F(n−2)F(n)=F(n−1)+F(n−2)，运算过程中仅存储这三个数值即可
     *  ·初始状态： F[0] = 1, F[1] = 1，因为在计算 n 时需要 2 个元素，所以要初始化 2 个值；
     * 2.其中取模 1000000007 运算主要是为了避免数字溢出，这步运算在每次计算出新的斐波那契数时进行即可，因为模运算的特性，后续再进行加法运算也不会有任何影响
     * 模运算特性：(x + y) \% z = ((x \% z) + (y \% z)) \% z(x+y)%z=((x%z)+(y%z))%z
     * 3.为什么要对 1000000007 取模
     *  ·1000000007 是一个质数（素数），对质数取模能最大程度避免冲突
     *  ·int32 位的最大值为 2147483647，所以对于 int32 位来说 1000000007 足够大
     *  ·int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出
     *
     */
    public static int numWays(int n){
        int n1=1,n2=1,sum;
        for (int i=0;i<n;i++){
            sum = (n1+n2) % 1000000007;
            n1 = n2;
            n2 = sum;
        }
        return n1;
    }
}
