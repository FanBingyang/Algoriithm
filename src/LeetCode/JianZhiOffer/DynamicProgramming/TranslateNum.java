package LeetCode.JianZhiOffer.DynamicProgramming;

/**
 * @Author: FBY
 * @Date: 2021/4/26 11:07
 * @Version 1.0
 */

/**
 * 题目描述
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 "a" ，1 翻译成 "b"，……，11 翻译成 "l"，……，25 翻译成 "z"。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入：12258
 * 输出：5
 * 解释：12258 有 5 种不同的翻译，分别是 "bccfi","bwfi","bczi","mcfi" 和 "mzi"
 */
public class TranslateNum {
    /**
     * 思路
     * ·标签：动态规划
     * ·整体思路：
     *      ·翻译方案可能与前两步骤有关，令 dp[n] 表示第 nn 个位置方案数量，第 [n] 位与区间 [0:n-1] 位必然可以组成 dp[n-1] 个方案，如果前两位 [n-1:n] 组成的数字在区间 10-26 之间，第 [n-1:n] 位与区间 [0:n-2] 位必然可以组成 dp[n-2]个方案，所以可以根据该思路写出动态规划方程
     * ·复杂度：
     *      ·时间复杂度：O(n)。n 代表 num 的数字长度，需要遍历 n 次
     *      ·空间复杂度：O(n)。需要将 num 转为字符串，所以要消耗字符串长度 n 的空间
     * 算法流程
     * 1.状态定义： dp[n] 表示第 n 个位置方案数量
     * 2.转移方程：
     *  令 [n-2:n] 组成的数字为 x（x为两位数，如果10<=x<=25则表示能被当作一个整体翻译）
     *  ·dp[n] = dp[n-1] + dp[n-2], x >= 10 && x <= 25
     *  ·dp[n] = dp[n-1], x < 10 && x > 25
     * 3.初始状态：dp[0] = 1，dp[1] = 1
     * 4.因为该动态规划只需要 n-1 和 n-2 步骤的数据即可，所以可以不使用 dp 数组存储，使用 2 个变量存储数值即可
     */
    public int translateNum(int num){
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int x=1,y=1;
        for (int i = 2; i <= len; i++) {
            String sub = numStr.substring(i-2,i);
            int z = sub.compareTo("10")>=0 && sub.compareTo("25")<=0 ? x+y:x;
            y = x;
            x = z;
        }
        return x;
    }
}
