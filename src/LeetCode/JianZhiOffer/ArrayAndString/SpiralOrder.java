package LeetCode.JianZhiOffer.ArrayAndString;

/**
 * @Author: FBY
 * @Date: 2021/4/6 23:09
 * @Version 1.0
 */

import java.util.Scanner;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 解题方案
 思路
 ·标签：二维数组
 ·整体思路：循环遍历整个数组，循环中再嵌套四个循环，分别是从左至右，从上至下，从右至左，从下至上这几个方向，按照题意将整个数组遍历完成，控制好边界
 ·m 为行数，n 为列数，时间复杂度：O(mn)，空间复杂度：O(1)
 算法流程
 1.题目中 matrix 有可能为空，直接返回空数组即可
 2.初始化边界 left、right、top、bottom 四个值，初始化结果数组 res 和数组下标 x
 3.按照遍历方向循环取出数字放入结果数组中
 ·从左至右：遍历完成后 ++top，如果 top > bottom，到达边界循环结束
 ·从上至下：遍历完成后 --right，如果 left > right，到达边界循环结束
 ·从右至左：遍历完成后 --bottom，如果 top > bottom，到达边界循环结束
 ·从下至上：遍历完成后 ++left，如果 left > right，到达边界循环结束
 
 */
public class SpiralOrder {
    public static int[] spiralOrder(int[][] matrix){
        if (matrix.length == 0)
            return new int[0];
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int x = 0;
        int[] res = new int[(right+1) * (bottom+1)];
        while (true){
            // 从左到右
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            // 扫完一行之后top下移(++top)
            if (++top > bottom)
                break;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }
            // 扫完一列之后right左移(--right)
            if (left > --right)
                break;
            // 从右到左
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }
            // 扫完一行后bottom上移(--bottom)
            if (top > --bottom)
                break;
            // 从下往上
            for (int i = bottom; i >= top ; i--) {
                res[x++] = matrix[i][left];
            }
            // 扫完一列后left右移(++left)
            if(++left > right)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] res = spiralOrder(matrix);
        for (int i:res){
            System.out.println(i);
        }
    }
}
