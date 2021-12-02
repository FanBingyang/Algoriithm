package LeetCode.JianZhiOffer.Mathematics;

/**
 * @Author: FBY
 * @Date: 2021/4/29 16:14
 * @Version 1.0
 */

/**
 * 题目描述
 * 数字以 0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第 5 位（从下标 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。
 * 请写一个函数，求任意第 n 位对应的数字。
 *
 * 示例 1:
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2:
 * 输入：n = 11
 * 输出：0
 *
 */
public class FindNthDigit {
    /**
     * 思路
     * ·标签：迭代，取余
     * ·整体思路：根据初始字符串很容易找到数学规律：
     *      ·123456789:是 9 个 1 位数字
     *      ·1011121314...9899:是 90 个 2 位数字
     *      ·100...999:是 900 个 3 位数字
     * ·复杂度：
     *      ·时间复杂度：O(logn) 所求数位 n 对应数字 num 的位数 digit 最大为 O(logn)；第一步最多循环 O(logn)；第三步中将 num 转化为字符串使用 O(logn)时间；因此总体为 O(logn)
     *      ·空间复杂度：O(logn)： 将数字转化为字符串时占用额外空间 O(logn)
     * 算法流程
     * 1.先找到输入的数字对应的是几位数 digit
     * 2.然后确定这个数的数值 num
     * 3.最后找到是该数值的第几位数
     * 4.返回结果
     */
    public int findNthDigit(int n){
        int digit = 1;
        long start = 1;   // 每个位数的起始数字
        long count = 9;
        while (n > count){      // 第一步
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n-1) / digit;   // 第二步
        return  Long.toString(num).charAt((n-1) % digit) - '0';   // 第三步: 数字字符减去数字字符0就是数字
    }
}
