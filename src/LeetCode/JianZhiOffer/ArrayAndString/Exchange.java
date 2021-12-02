package LeetCode.JianZhiOffer.ArrayAndString;

/**
 * @Author: FBY
 * @Date: 2021/4/1 15:04
 * @Version 1.0
 */

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 * 1.1 <= nums.length <= 50000
 * 2.1 <= nums[i] <= 10000
 *
 * 解题方案
 * 思路
 * ·标签：双指针
 * ·整体思路：首先指定前指针 start 和后指针 end，然后前指针定位偶数，后指针定位奇数，定位到之后将两个值互换，直到数组遍历完成
 * ·时间复杂度：O(n)，空间复杂度：O(1)
 * 算法流程
 * 1.初始化前指针 start = 0，后指针 end = nums.length - 1
 * 2.当 start < end 时表示该数组还未遍历完成，则继续进行奇数和偶数的交换
 * 3.当 nums[start] 为奇数时，则 start++，直到找到不为奇数的下标为止
 * 4.当 nums[end] 为偶数时，则 end--，直到找到不为偶数的下标为止
 * 5.交换 nums[start] 和 nums[end]，继续下一轮交换
 * 6.返回 nums，即为交换后的结果
 *
 */
public class Exchange {

    public static int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            while (start<end && (nums[start]%2)==1){
                start++;
            }
            while (start<end && (nums[end]%2)==0){
                end--;
            }
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
        return nums;
    }

    /**
     * 思路：
     * ·设置左右双指针，初始化时第一个数和最后一个数的角标。
     * ·当L<R的时候，表示数组还未完成遍历，继续进行遍历。
     * ·当左边的数为偶数时，右边的数为奇数时进行交换，右边的数为偶数则后指针往前移
     * ·当左边的数为奇数时，右边的数为奇数，前指针后移，有变数为偶数时，前指针后移且后指针前移。
     * @param nums
     * @return
     */
    public static int[] Myexchange(int[] nums) {
        int L=0,R=nums.length-1;
        while (L<R){
            if (nums[L]%2==0){
                if (nums[R]%2!=0) {
                    int t = nums[L];
                    nums[L] = nums[R];
                    nums[R] = t;
                    L++;
                    R--;
                }else R--;
            }else{
                if (nums[R]%2!=0)
                    L++;
                else {
                    L++;
                    R--;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        System.out.println("====="+nums.length);
        int[] numm = exchange(nums);
        for (int j=0;j<numm.length;j++){
            System.out.println(numm[j]);
        }
    }
}
