package LeetCode.JianZhiOffer.ArrayAndString;

/**
 * @Author: FBY
 * @Date: 2021/4/7 17:24
 * @Version 1.0
 */

import java.util.Scanner;

/**
 * 题目描述
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0～n-1 之内。在范围 0～n-1 内的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 * 1 <= 数组长度 <= 10000
 *
 * 解题方案
 * 思路
 * ·标签：数组、二分查找
 * ·整体思路：
 *      ·因为数组从0增序存储，所以如果不缺失则数字与数组索引对应。缺失的数字等于 “右子数组的首位元素” 对应的索引，因此考虑使用二分法查找 “右子数组的首位元素”。
 *      ·左子数组： nums[i] == i，数字与数组索引相等，则前半部分没有缺失，在右半部分查找
 *      ·右子数组： nums[i] != i，数字与数组索引不相等，则缺失数字在左半部分
 * ·复杂度：
 *      ·时间复杂度：O(logn)
 *      ·空间复杂度：O(1)
 * 算法流程
 * 1.首先初始化二分查找的左边界 left = 0，右边界 right = nums.length - 1
 * 2.当左边界不大于右边界时进行查找
 * 3.计算 mid = (left + right) / 2
 * 4.如果 nums[mid] == mid 则缺失的元素，即右子数组的首位元素在 [mid + 1, right] 中间，令 left = mid + 1
 * 5.如果 nums[mid] != mid 则缺失的元素，即右子数组的首位元素在 [left, mid - 1] 中间，令 right = mid - 1
 *
 */
public class MissingNumber {
    public static int missingNumber(int[] nums){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (mid == nums[mid])
                left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组大小：");
        int n = sc.nextInt();
        System.out.println("按要求挨个输入数组数字：");
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("缺失的数字为"+missingNumber(nums));
    }
}
