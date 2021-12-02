package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/8 15:16
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串 "I am a student. "，则输出 "student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 *
 * 示例 2：
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * ·无空格字符构成一个单词。
 * ·输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * ·如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 解题方案
 * 思路
 * ·标签：双指针
 * ·整体思路：先将开头和结尾处多余的空格去掉，从后向前遍历，通过前后指针锁定单词，跳过中间空格，最终将整个句子中的单词反转
 * ·时间复杂度：O(n)，空间复杂度：O(n)
 * 算法流程
 * 1.首先将原始字符串去掉开头和结尾的空格得到 tmp，便于之后直接从单词处理开始
 * 2.初始化单词起始位置 start 和单词结束位置 end 指针，位置在字符串结尾处
 * 3.初始化结果字符串 res 为空字符串
 * 4.当 start >= 0 时，说明字符串未遍历结束，作为循环条件
 * 5.在 tmp[start] 位置如果不为空格，说明还没有获取到完整的单词，则 start--
 * 6.获取到完整单词之后，截取 [start+1, end+1] 这一段字符串加入结果字符串中，反转单词
 * 7.在 tmp[start] 位置如果为空格，说明还没有到下一个单词的结尾位置，则 start--
 * 8.到单词结尾位置之后，end = start，往复进行上述流程，将单词全部反转
 * 9.将结果字符串 res 去掉开头和结尾多余的空格
 *
 */
public class ReverseWords {

    public static String reverseWords(String s){
        String tmp = s.trim();
        int start = tmp.length()-1;
        int end = tmp.length()-1;
        String res = "";
        while (start >= 0){
            while (start>=0 && tmp.charAt(start)!=' '){
                start--;
            }
            res += tmp.substring(start+1,end+1) + " ";
            while (start>=0 && tmp.charAt(start)==' '){
                start--;
            }
            end = start;
        }
        return res.trim();
    }


    /**
     * 思路：
     * 先除去字符串两端的空格，然后依次遍历字符串中的字符，如果该字符不是空格，那么加在word临时变量之后，
     * 如果该字符是空格，那么证明至少扫描完一个单词，此时判断单词是否为空，不为空在加在返回字符串的前面，中间用空格连接
     * 遍历完字符串之后，再次判断单词是否为空，不为空在加在返回字符串的前面，中间用空格连接
     * 最后将拼接好的字符串两端去除空格后返回
     */
    public static String MyreverseWords(String s){
        String tmp = s.trim();
        String res = "";
        String word = "";
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c != ' '){
                word += c;
            }else if (word!=""){
                res = word + " " + res;
                word = "";
            }
        }
        if (word!=""){
            res = word + " " + res;
            word = "";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(MyreverseWords(s));
    }
}
