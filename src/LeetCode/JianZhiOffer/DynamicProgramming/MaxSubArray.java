package LeetCode.JianZhiOffer.DynamicProgramming;

/**
 * @Author: FBY
 * @Date: 2021/4/26 10:29
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为 O(n)。
 *
 * 示例 1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 */
public class MaxSubArray {

    /**
     * 思路
     * ·标签：动态规划
     * ·整体思路：通过动态规划计算每一步的状态可以在遍历数组结束后得到结果，成为最优解
     * ·时间复杂度：O(n)，空间复杂度：O(1)
     * 算法流程
     * 1.状态定义：动态规划数组为 dp，dp[i] 表示以 nums[i] 结尾的连续子数组最大和
     * 2.状态转移方程：
     *  ·当 dp[i - 1] > 0 时，则 dp[i] = dp[i-1] + nums[i]，因为此时 dp[i - 1] 产生正向增益，所以要加上去
     *  ·当 dp[i - 1] ≤ 0 时，则 dp[i] = nums[i]，因为此时 dp[i - 1] 产生负向增益，所以不需要添加
     * 3.初始状态：dp[0] = nums[0]
     * 4.结果值：dp 数组中的最大值，就是最终的结果
     * 5.其中为了降低空间复杂度，可以将 dp 数组与 nums 数组合并，避免开辟新的内存空间
     */
    public static int maxSubArray(int[] nums){
        int res = nums[0];
        for (int i = 1;i< nums.length;i++){
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
