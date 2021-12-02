package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/7 13:57
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示: 0 < nums.length <= 1000<nums.length<=100
 *
 * 解题方案
 * 思路
 * ·标签：排序
 * ·整体思路：
 *      ·拼接数组内所有元素使结果最小，本质上是排序
 *      ·若字符串拼接 a + b > b + a，那么排序上 b < a;
 *      ·根据这个规则对数组内的元素排序
 * ·复杂度：
 *      ·时间复杂度：O(nlogn)。n 为 strList 列表长度，使用 java 内置函数的平均时间复杂度为 O(nlogn)， 最差为O(nlogn)
 *      ·空间复杂度：O(n)： 字符串列表 strList 占用线性大小的额外空间。
 *
 * 算法流程
 * 1.将数组内的元素存入字符串列表 strList
 * 2.根据上述排序规则，对列表进行排序
 * 3.最后返回拼接的字符串
 *
 */
public class MinNumber {

    public static String minNumber(int[] nums){
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        // 按照自定义的排序规则对strList进行排序。(a,b) -> (a+b).compareTo(b+a)
        strList.sort((a,b) -> (a+b).compareTo(b+a));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(minNumber(nums));
    }
}
