package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/7 14:31
 * @Version 1.0
 */

/**
 *题目描述
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * 解题方案
 * 思路
 * ·标签：数组、二分查找
 * ·整体思路：
 *      ·因为数组本身是有序的，所以利用二分查找可以降低时间复杂度，但是因为数组中的数字存在重复，所以找到 target 在数组中对应的左右边界非常重要
 *      ·容易想到的方式就是分别用二分查找的方式去查找 target 在数组的左边界和右边界，然后将右边界减左边界即可得到结果
 *      ·分别查找 target 左边界和右边界的逻辑会有差异，这里可以取巧，变成分别查找 target-1 的右边界和 target 的右边界，结果是一样的，但是代码可以进行复用了
 * ·复杂度：
 *      ·时间复杂度：O(logn)O(logn)。二分查找的时间复杂度是O(logn)O(logn)
 *      ·空间复杂度：O(1)O(1)。只需要保存左右边界和中间值即可
 * 算法流程
 * 1.首先初始化二分查找的左边界left = 0，右边界right = nums.length - 1
 * 2.当左边界不大于右边界时进行查找
 * 3.计算 mid = (left + right) / 2
 * 4.如果 nums[mid] <= target，则右边界在 [mid + 1, right] 中间，令 left = mid + 1
 * 5.如果 nums[mid] > target，则右边界在 [left, mid - 1] 中间，令 right = mid - 1
 */
public class SearchCount {

    public int search(int[] nums, int target) {
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }
    int getRightMargin(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * 思路：
     * 因为数组本身是有序的，所以利用二分查找，但是因为数组中有重复数字，
     * 所以查询到当前结果之后还需要再对左右进行查询，统计出总的出现次数。
     * 算法流程：
     * 1.首先初始化二分查找的左边界left=0；右边界right=nums.length-1
     * 2.开始查找，计算mid = (left + right) / 2，当左边界小于右边界时进行二分查找
     * 3.如果nums[mid]==target，则在左右部分继续查找[left,mid-1]和[mid+1,right]，返回值是左右部分返回值之和再加1.
     * 4.如果nums[mid]<target，则在右半部分进行查找关键字，[mid+1,right]
     * 5.如果nums[mid]>target，则在左半部分进行查找关键字，[left,mid-1]
     */

    public static int Mysearch(int[] nums, int target) {
        int left=0,right= nums.length-1;
        return searchErfen(nums,left,right,target);
    }
    public static int searchErfen(int[] nums,int left,int right,int target){
        int mid = (left + right) / 2;
        if (left<=right) {
            if (target == nums[mid]) {
                return 1 + searchErfen(nums, left, (mid - 1), target) + searchErfen(nums, (mid + 1), right, target);
            } else if (target < nums[mid]) {
                return searchErfen(nums,left,(mid-1),target);
            } else
                return searchErfen(nums,(mid + 1), right, target);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Mysearch(nums,target));
    }
}
