package LeetCode.JianZhiOffer.BitOperation;

/**
 * @Author: FBY
 * @Date: 2021/4/27 20:00
 * @Version 1.0
 */

/**
 *题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 提示：
 * ·a,b 均可能是负数或 0
 * ·结果不会溢出 32 位整数
 */
public class Add {
    /**
     * 思路
     * ·标签：位运算
     * ·整体思路：
     *      ·这道题在不让用四则基础运算的基础上把结果算出来，说明只能利用二进制的位运算来求解
     *      ·其中无进位和用 n 表示，进位用 c 表示，sum = a + b = n + c，位运算可以分别计算出来这两个
     *      ·以 2 个 1 位的二进制数字求和为例，共有 4 种情况，观察下规律，进行位运算求和公式推导
     *      ·从表中可以看出来，无进位和 n = a⨁b，进位 c = a & b << 1
     *      ·在 sum = n + c 的计算中，还是使用了加法，进而这种加法运算可以再次使用位运算来解决，这里就是一个循环的思路
     *      ·循环结束的条件是c = 0，因为当c = 0时，sum = n + c = n + 0 = n的，所以n就是最终的结果
     * a	b	无进位和 n	进位 c
     * 0	0	   0	     0
     * 0	1	   1	     0
     * 1	0	   1	     0
     * 1	1	   0	     10
     * ·复杂度：
     *      ·时间复杂度：O(1)。因为题目中提到结果不会溢出 32 位整数，所以最多进行 32 次循环
     *      ·空间复杂度：O(1)。只需要存储无进位和和进位即可
     * 算法流程
     * 1.当进位不为 0 时进行循环
     * 2.使用公式 c = a & b << 1 计算出进位值
     * 3,根据公式 n = a⨁b  （n=a^b） 求出无进位和
     * 4.无进位和和进位值依次放到 a、b 中，进行下一次循环
     */
    public int add(int a, int b) {
        while (b!=0){
            int carry = (a & b) << 1;
            int n = a ^ b;
            a = n;
            b = carry;
        }
        return a;
    }
}
