package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/9 10:01
 * @Version 1.0
 */

/**
 * 题目描述
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 解题方案
 * 思路
 * ·标签：数组遍历
 * ·整体思路：
 *      ·这道题如果可以使用除法，那么就很简单了，先求出来所有数的乘积，然后再依次除掉每个对应的值即可
 *      ·不让使用除法，那么最简单的思路就是将B[i]每个位置都把所有需要的数乘一遍，但是这样的时间复杂度非常高
 *      ·降低时间复杂度的方式就是以A[i]为界线，分割出左右三角形，其中每个三角形从尖部到底部都是可以累积的，这样就可以减少时间复杂度（具体见画）
 * ·复杂度：
 *      ·时间复杂度：O(n)。因为左右三角遍历求乘积的时间复杂度都是O(n)
 *      ·空间复杂度：O(1)。不将结果数组算入的话，只需要常量的空间复杂度
 * 算法流程
 * 1.首先申请结果数组 res
 * 2.求出左侧三角从上到下的值，依次存入 res[i] 中
 * 3.求出右侧三角从下到上的值，并且和之前的 res[i] 做乘积存入，即可得到结果
 *
 */
public class ConstructArr {

    public static int[] constructArr(int[] a){
        int[] res =  new int[a.length];
        int left = 1;
        for (int i = 0; i < a.length; i++) {
            res[i] = left;
            left *= a[i];
        }
        int right = 1;
        for (int i = a.length-1; i >= 0; i--) {
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }


    /**
     * 思路：（超时了）
     * ·循环遍历数组，当i==j时不操作，i！=j且a[j]!=1时，进行累乘，最后赋值给b[i]
     */
    public static int[] MyconstructArr(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int arg = 1;
            for (int j = 0; j < a.length; j++) {
                if (j != i && a[j]!=1){
                    arg *= a[j];
                }
            }
            b[i] = arg;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = constructArr(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }
}
