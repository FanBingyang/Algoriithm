package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/7 19:53
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字 s，在数组中查找两个数，使得它们的和正好是 s。如果有多对数字的和等于 s，则输出任意一对即可。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * 解题方案
 * 思路
 * ·标签：双指针
 * ·整体思路：因为数组本身是有序的，那么完全可以在数组的开头 start 和结尾 end 位置各设置一个指针，通过二者的加和 sum 来找到目标值 target，如果 sum < target，则 start++，这样可以让下一次的 sum 变大，如果 sum > target，则 end--，这样可以让下一次的 sum 变小，找到结果
 * ·时间复杂度：O(n)，空间复杂度：O(1)
 * 算法流程
 * 1.首先初始化 start = 0，end = nums.length - 1，作为双指针
 * 2.当 start < end 时，始终进行循环遍历
 * 3.计算 sum = nums[start] + nums[end]，并将 sum 与 target 进行比较
 * 4.如果 sum < target，则需要将下一次的 sum 值变大，因为数组有序，故而 start++
 * 5.如果 sum > target，则需要将下一次的 sum 值变小，因为数组有序，故而 end--
 * 6.如果 sum == target，则找到了最终的结果，将结果返回即可
 */
public class TwoSum {

    public static int[] twosum(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            int sum = nums[start] + nums[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else
                return new int[] {nums[start],nums[end]};
        }
        return new int[0];
    }

    /**
     * 思路：
     * ·遍历数组，依次取当前数位第一个数，将目标数减第一个数，如果差大于0，那么在剩余数组中进行二分查找该差值，也就是第二个数。
     */
    public static int[] Mytwosum(int[] nums,int target){
        int[] res = new int[2];
        for (int i=0;i< nums.length;i++){
            int one = nums[i];
            int two = target-one;
            if(two>0){
                int left=i+1,right= nums.length-1;
                while (left<=right){
                    int mid = (left+right)/2;
                    if (two<nums[mid])
                        right = mid-1;
                    else if (two>nums[mid])
                        left = mid+1;
                    else {
                        res[0] = one;
                        res[1] = two;
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        for (int num : Mytwosum(nums,target)) {
            System.out.println(num);
        }
    }
}
