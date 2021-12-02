package Test;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/28 16:26
 * @Version 1.0
 */

/**
 * 给定一个字符串，翻转里面得单词。当单词只包含字母时，进行翻转；当单词包含有其他字符时，不反转。
 * 示例：
 * 输入：hello a2 abcd good!
 * 输出：olleh a2 dcba good!
 */
public class test_3 {
    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        String str = sin.nextLine();
        System.out.println(solution(str));
    }

    public static String solution (String str){
        // 在此写出正确答案
        StringBuilder sb = new StringBuilder();
        String word = "";
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c != ' '){
                word += c;
            }else if(word != ""){
                sb.append(fun(word)+" ");
                word = "";
            }
        }
        if (word != ""){
            sb.append(fun(word));
        }
        return sb.toString();
    }

    public static String fun(String str){
        String word = "";
        for (int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if ((c>='a' && c<='z') || (c>='A' && c<='Z'))
                word += c;
            else
                return str;
        }
        return word;
    }
}
