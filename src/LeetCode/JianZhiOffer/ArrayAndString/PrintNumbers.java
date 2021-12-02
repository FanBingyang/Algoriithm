package LeetCode.JianZhiOffer.ArrayAndString;

/**
 * @Author: FBY
 * @Date: 2021/3/31 9:43
 * @Version 1.0
 */


/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 * ·用返回一个整数列表来代替打印
 * ·n 为正整数
 * 解题方案
 * 思路 1
 * ·标签：数组
 * ·整体思路：首先求出要打印的数字范围，然后再从 1 开始打印到最大的数字
 * ·时间复杂度：O(10^n)，空间复杂度：O(10^n)
 *
 * 算法流程 1
 * 1.初始化 sum = 1
 * 2.循环遍历乘 10 让 sum 变为边界值
 * 3.新建 res 数组，大小为 sum-1
 * 4.从 1 开始打印，直到 sum-1 为止
 */
public class PrintNumbers {

    public static int[] printNumbers(int n){
        int sum = 1;
        for (int i=0;i<n;i++){
            sum *=10;
        }
        int[] res = new int[sum-1];
        for (int i = 0; i < sum - 1; i++) {
            res[i] = i+1;
        }
        return res;
    }

    /**
     * 思路 2
     * ·标签：字符串
     * ·整体思路：原题的题意其实是希望考察大数计算，因为 int 数组有可能会溢出，所以用字符串处理可以保证一定不会溢出，但是呢，由于返回值规定是 int 数组，所以其实从返回值上来看，是一定不会溢出的，比较矛盾。所以给出个思路 2，学习下如何用字符串处理大数即可，不用特别纠结溢出这件事情
     * ·时间复杂度：O(10^n)，空间复杂度：O(10^n)
     *
     * 算法流程 2
     * 1.初始化字符串 str，另其初始值为 n-1 个 "0"
     * 2.递增 str，使用字符去递增，递增过程中判断是否存在进位，存在进位则进位处 +1，直到达到最大值为止，结束循环
     * 3.每获取到一个值之后，遍历前方多余的 "0"，将多余的 "0" 去掉，转换为 int 存到结果数组中
     */
    public static int[] printNumbers2(int n){
        int[] res = new int[(int) Math.pow(10,n) - 1];
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        int count = 0;
        while (!increment(str)){
            int index = 0;
            while (index<str.length() &&  str.charAt(index)=='0'){
                index++;
            }
            res[count] = Integer.parseInt(str.toString().substring(index));
            count++;
        }
        return res;
    }

    public static boolean increment(StringBuilder str) {
        boolean isCarry = false;
        for (int i = str.length()-1; i >= 0; i--) {
            char s = (char) (str.charAt(i)+1);
            if (s>'9'){
                str.replace(i,i+1,"0");
                if (i == 0){
                    isCarry = true;
                }
            }else {
                str.replace(i,i+1,String.valueOf(s));
                break;
            }
        }
        return isCarry;
    }



    public static int[] MyprintNumbers(int n){
        int sum = (int) Math.pow(10,n);
        int[] numbers = new int[sum-1];
        for (int i=1;i<sum;i++){
            numbers[i-1] = i;
        }
        return numbers;
    }

    public static void main(String[] args) {


    }
}
