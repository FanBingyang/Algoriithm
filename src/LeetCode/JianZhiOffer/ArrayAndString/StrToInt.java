package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/9 10:30
 * @Version 1.0
 */

/**
 * 题目描述
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *     因此返回 INT_MIN (−231) 。
 *
 * 解题方案
 * 思路
 * ·标签：处理数字越界
 * ·整体思路：
 *      ·前端空格
 *      ·“+”，“-”正负号
 *      ·首个字符为非数字
 *      ·数字字符处理
 *
 * ·复杂度：
 *      ·时间复杂度：O(n) ：其中 n 为字符串长度，线性遍历字符串占用 O(n) 时间
 *      ·空间复杂度：O(n)： 删除首尾空格后需建立新字符串，最差情况下占用 O(n) 额外空间。
 * 算法流程
 * 1.删除首位空格
 * 2.声明一个变量保存符号位
 * 3.首位字符非数字直接返回
 * 4.若为数字字符，从左向右遍历字符集，若当前数字为 x， 数字结果为 res，则遍历中 res 结果为 res = res * 10 + x
 * 5.获得下一次遍历结果前判断是否越界，如果超过 2147483647，直接返回
 * 6.返回结果
 */
public class StrToInt {

    public static int strToInt(String str){
        char[] c = str.trim().toCharArray();
        if (c.length == 0 ){
            return 0;
        }
        int res=0;
        int boundry = Integer.MAX_VALUE/10;
        int start=1,sign=1;
        if (c[0] == '-')
            sign = -1;
        else if (c[0] != '+')
            start=0;
        for (int i = start; i < c.length; i++) {
            if (c[i]<'0' || c[i]>'9')
                break;
            if (res>boundry || res == boundry && c[i]>'7')
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res * 10 + (c[i] - '0');
        }
        return sign*res;
    }

//    public static int MystrToInt(String str){
//        int res=0;
//        String s = str.trim();
//        String tmp = "";
//        char sign = '+';
//        if (s.length() == 0){
//            return res;
//        }
//        if (s.charAt(0)=='-'){
//            sign = '-';
//        }else if (s.charAt(0)=='+'){
//            sign = '+';
//        }
//        else if (s.charAt(0)<='9' && s.charAt(0)>='0'){
//            tmp += s.charAt(0);
//        }else
//            return res;
//        for (int i = 1; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c>='0' && c<='9'){
//                tmp += c;
//            }else
//                break;
//        }
////        if (tmp.length()==0 || (tmp.length()==1 && tmp.charAt(0)=='-'))
////            return res;
//        if (tmp.length() == 0)
//            return  res;
//        if (tmp.compareTo(String.valueOf(Integer.MAX_VALUE))>=0){
//            if (sign=='-'){
//                res = Integer.MIN_VALUE;
//            }
//            else res = Integer.MAX_VALUE;
//        }else if (sign=='-'){
//            res = 0-Integer.parseInt(tmp);
//        }else
//            res = Integer.parseInt(tmp);
////        long l = Long.parseLong(tmp);
////        if (l>=Integer.MAX_VALUE){
////            res = Integer.MAX_VALUE;
////        }else if (l<=Integer.MIN_VALUE){
////            res = Integer.MIN_VALUE;
////        }else{
////            res = (int) l;
////        }
////        if (tmp.compareTo(String.valueOf(Integer.MAX_VALUE))>=0){
////            res = Integer.MAX_VALUE;
////        }else if (tmp.compareTo(String.valueOf(Integer.MAX_VALUE))>=0)
//        return res;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = strToInt(str);
        System.out.println(num);
    }
}
