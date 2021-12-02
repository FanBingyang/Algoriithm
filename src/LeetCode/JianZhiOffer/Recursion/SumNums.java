package LeetCode.JianZhiOffer.Recursion;

/**
 * @Author: FBY
 * @Date: 2021/4/29 16:02
 * @Version 1.0
 */

/**
 * 题目描述
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出:6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出:45
 *
 * 限制：
 * 1 <= n <= 10000
 */
public class SumNums {
    /**
     * 思路
     * ·标签：递归、短路
     * ·整体思路：
     *      ·首先由于题目限制，排除了公式计算、循环迭代和普通递归的方式
     *      ·普通递归算法中的终止条件和条件判断可以用与运算的短路效应来替代
     * ·复杂度：
     *      ·时间复杂度：O(n)。需要递归计算 n 次
     *      ·空间复杂度：O(n)。递归产生的函数调用栈深度为 n
     * 算法流程
     * 1.普通递归的方式求和代码如下：
     *  class Solution {
     *         public int sumNums(int n) {
     *             return n == 0 ? 0 : n + sumNums(n - 1);
     *         }
     *  };
     * 2.与运算的短路效应指的是
     *  ·当出现 conditionA && conditionB 场景时，如果 conditionA 不成立，那么conditionB也不会执行
     *  ·当出现 conditionA || conditionB 场景时，如果 conditionA 成立，那么conditionB也不会执行
     * 3.因为短路效应，所以其中的三元运算符条件判断可以用与运算来进行代替
     */
    public int sumNums(int n){
        // 其中 tmp 和 (n += sumNums(n - 1)) > 0 中的大于0条件都是为了做短路运算符合语法要求加的，并没有实际意义
        boolean tmp = n>0 && (n += sumNums(n-1))>0;
        return n;
    }
}
