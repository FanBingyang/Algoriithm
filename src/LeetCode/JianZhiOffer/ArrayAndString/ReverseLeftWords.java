package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/8 22:19
 * @Version 1.0
 */

/**
 * 题目描述
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 *
 * 解题方案
 * 思路
 * ·标签：字符串遍历
 * ·整体思路：在原字符串处从需要反转的位置 n 开始向后遍历，并保存到结果字符串中，然后再从原字符串的初始位置遍历到位置 n，继续添加到结果字符串
 * ·时间复杂度：O(n)，空间复杂度：O(n)
 * 算法流程
 * 1.初始化结果字符串 res = ""，获取字符串长度 len
 * 2.从下标 n 开始遍历，遍历到字符串 s 结尾，将区间 [n, len] 的字符添加到 res 中
 * 3.从下标 0 开始遍历，遍历到下标 n 位置，将区间 [0, n] 的字符添加到 res 中
 *
 */
public class ReverseLeftWords {
    public static String reverseLeftWords(String s,int n){
        String res = "";
        int len = s.length();
        for (int i = n; i < len; i++) {
            res += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            res += s.charAt(i);
        }
        return res;
    }


    /**
     * 思路：
     * 截取字符串值定位置的后半段和前半段进行拼接
     */
    public static String MyreverseLeftWords(String s,int n){
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(reverseLeftWords(s,n));
    }
}
