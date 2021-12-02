package LeetCode.Code;

/**
 * @Author: FBY
 * @Date: 2021/4/20 14:44
 * @Version 1.0
 */

/**
 * 全排列
 * 输入一个字符串，求出该字符串的所有的排列
 *
 * 示例1
 * 输入：abc
 * 输出：abc acb bac bca cab cba
 *
 * 多个字符串的全排列，我们可以分为两步，首先求可能出现在第一个位置的所有字符，即把第一个字符和后面的所有的字符进行交换，
 * 第二步当固定了第一个字符后，我们对于第一个字符后面的字符，我们仍然把后面的字符分为第一个字符，以及第一个字符后面的字符，
 * 即将后面部分的第一个字符和后面部分的其他字符进行交换，按照上面的步骤，当每一位的字符都固定，即输出一个结果。
 * 总结，对于每一位，依次将后面的部分和该位字符进行交换，我们以得到该位的所有全排列，当我们固定了一位之后，接下来求解的就是这一位之后的字符的全排列，
 * 依然按照先固定一位，后求该位后面的字符全排列的思想。
 */
public class Permutation {

    public static void permutation(String str){
        if (str==null || str.length()==0)
            return;
        allpermutation(str.toCharArray(),0);
    }

    public static void allpermutation(char[] charArr,int begin){
        if (begin== charArr.length){
            System.out.println(charArr);
        }
        for (int i=begin;i< charArr.length;i++){
            // 将第一个字符和后面的字符依次交换
            swop(charArr,i,begin);
            // 对于第一个字符后面的字符，依次和后面的字符进行交换
            allpermutation(charArr,begin+1);
            // 由于还要交换其他位到该位，因此要将字符串恢复到未交换的时候的样子
            swop(charArr,i,begin);
        }
    }

    public static void swop(char[] charArr,int i,int j){
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        permutation(str);
    }
}
