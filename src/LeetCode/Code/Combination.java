package LeetCode.Code;

/**
 * @Author: FBY
 * @Date: 2021/4/20 11:16
 * @Version 1.0
 */

/**
 * 组合
 * 求一个字符串的所有的组合，我们可以考虑求一个字符串中一位组合，两位组合，…一直到n位组合，
 * 在求m(1<=m<=n)位的组合时，又如下两种情况：
 * （1）如果组合里面包含第一个字符串，则在剩下的n-1个字符中选择m-1个字符。
 * （2）如果组合里面不包括第一个字符，则在剩下的n-1个中选择m个字符
 *
 * 示例1：abcd
 * 输入：abcd
 * 输出：abc abd ab acd ac ad a bcd bc bd b cd c d
 *

 */
public class Combination {
    public static void combination(String str){
        if (str==null || str.length()==0){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        allCombine(str.toCharArray(),stringBuilder,0);
    }

    public static void allCombine(char[] charArr,StringBuilder stringBuilder,int begin){
        if (begin==charArr.length){
            System.out.println(stringBuilder);
        }else if (begin< charArr.length){
                // 添加第一个字符，从后面的字符中选择  iter-1个字符
                stringBuilder.append(charArr[begin]);
                allCombine(charArr,stringBuilder,begin+1);
                // 从剩下的n个中选择iter个
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                if (stringBuilder.length()==0 || stringBuilder.charAt(stringBuilder.length()-1)!=charArr[begin]){
                    allCombine(charArr,stringBuilder,begin+1);
                }
            }
    }

    public static void main(String[] args) {
        String str = "abcd";
        combination(str);
    }
}
