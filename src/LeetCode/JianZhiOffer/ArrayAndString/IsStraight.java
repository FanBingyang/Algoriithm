package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/8 22:34
 * @Version 1.0
 */

/**
 * 题目描述
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
 * 2 ～ 10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1：
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2：
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * ·数组长度为 5
 * ·数组的数取值为 [0, 13]
 *
 * 解题方案
 * 思路
 * ·标签：数组
 * ·整体思路：
 *      ·需要对数组升序排序
 *      ·如果数组中有重复数据，则返回 false
 *      ·令 minVal 为不包含大小王的最小值，如果 maxVal-minVal > 5，则返回 false
 * ·复杂度：
 *      ·时间复杂度 O(Nlog N)
 *      ·空间复杂度 O(1)
 * 算法流程
 * 1.顺子牌的定义
 * ·牌数量为 5
 * ·牌间的顺序为递增，且差值为 1
 * ·牌间不可以有重复数据，（大小王除外）。（扑克牌术语：如果一副牌里含有对子，则不可能是顺子）
 * ·大小王可以作为任意牌，即可以作为牌间空隙插入。且数量不限
 * ·牌之间的空隙个数为，maxVal-minVal
 * ·由于牌数量为 5，所以 maxVal-minVal <= 5
 *
 */
public class IsStraight {
    public static boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int zero_count = 0;
        if(nums.length != 5)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                zero_count++;
                continue;
            }
            if (i != nums.length-1){
                if (nums[i] == nums[i+1])
                    return false;
            }
        }
        return nums[nums.length-1] - nums[zero_count] < 5;
    }

    /**
     * 思路：
     * ·首先先对数组进行排序，然后统计出0的个数。
     * ·之后遍历0之后的数组部分，如果当前数与前一个数相等，返回false；否则0的个数变成当前0的个数减去当前数与前一个数的差再减一。就是看两个数之间需要几个0去补充
     * ·之后判断当0的个数小于0个之后，则返回false
     * ·最后0的个数大于等于0那么返回true
     */
    public static boolean MyisStraight(int[] nums){
        Arrays.sort(nums);
        int zero_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zero_count++;
            }else
                break;
        }
        for (int i = zero_count+1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return false;
            else {
                zero_count = zero_count-(nums[i]-nums[i-1]-1);
            }
            if (zero_count<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i=0;i<5;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(isStraight(nums));
    }
}
