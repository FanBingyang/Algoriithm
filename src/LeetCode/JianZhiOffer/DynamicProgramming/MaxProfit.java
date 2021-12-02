package LeetCode.JianZhiOffer.DynamicProgramming;

/**
 * @Author: FBY
 * @Date: 2021/4/26 20:17
 * @Version 1.0
 */

/**
 * 题目描述
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 限制：
 * 0 <= 数组长度 <= 10^5
 */
public class MaxProfit {

    /**
     * 思路
     * ·标签：动态规划
     * ·整体思路：
     *      ·根据题意如果将第x天买，第y天卖进行穷举的话，需要O(n^2)的时间复杂度，所以考虑使用动态规划来降低
     * ·复杂度：
     *      ·时间复杂度：O(n)O(n)。动态规划需要遍历数组一次
     *      ·空间复杂度：O(1)O(1)。只需要记录最小花费和最大收益
     * 算法流程
     * 1.状态定义： F[n] 表示 prices 中 0-n 下标的子数组的最大利润
     * 2.转移方程：
     *      ·前 n 天的最大利润 = max(前 n-1 天的最大利润，第 n 天的价格 - 前 n 天的最低价格)
     *      ·F[n] = max(F(n-1), min(prices[n], minCost))F[n]=max(F(n−1),min(prices[n],minCost))
     * 3.初始状态： F[0] = 0
     * 4.其中只需要记录 minCost 和 F(n-1) 这两个内容即可，不需要留存之前的动态规划记录，进而将空间复杂度从O(n)O(n)降低到了O(1)O(1)
     */
    public int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE;
        int maxBenefit = 0;
        for (int price:prices){
            minCost = Math.min(minCost,price);
            maxBenefit = Math.max(maxBenefit,price-minCost);
        }
        return maxBenefit;
    }
}
