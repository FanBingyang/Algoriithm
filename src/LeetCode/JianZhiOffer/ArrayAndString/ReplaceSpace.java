package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/3/30 22:54
 * @Version 1.0
 */

/**
 * 题目描述
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 解题方案
 * 思路
 * ·标签：字符串
 * ·最简单的方案自然是直接使用库函数啦！当然题目肯定是不希望我们这样做的！
 * ·增加一个新字符串，遍历原来的字符串，遍历过程中，如果非空格则将原来的字符直接拼接到新字符串中，如果遇到空格则将%20拼接到新字符串中
 * ·时间复杂度：O(n)，空间复杂度：O(n)
 *
 */
public class ReplaceSpace {

    public static String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == ' '){
                sb.append("%20");
            }
            else sb.append(c);
        }
        return sb.toString();
    }

    public static String replaceSpace2(String s) {
        String ss = s.replace(" ","%20");
        return ss;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace2(s));
    }
}
