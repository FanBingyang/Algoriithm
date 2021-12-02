package LeetCode.JianZhiOffer.ArrayAndString;

/**
 * @Author: FBY
 * @Date: 2021/3/30 23:27
 * @Version 1.0
 */

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 解题方案
 * 思路
 * ·标签：二分查找
 * ·整体思路：首先数组是一个有序数组的旋转，从这个条件可以看出，数组是有大小规律的，可以使用二分查找利用存在的规律快速找出结果
 * ·时间复杂度：O(logn)，空间复杂度：O(1)
 * 算法流程
 * 1.初始化下标 left 和 right
 * 2.每次计算中间下标 mid = (right + left) / 2，这里的除法是取整运算，不能出现小数
 * 3.当 numbers[mid] < numbers[right] 时，说明最小值在 [left, mid] 区间中，则令 right = mid，用于下一轮计算
 * 4.当 numbers[mid] > numbers[right] 时，说明最小值在 [mid, right] 区间中，则令 left = mid + 1，用于下一轮计算
 * 5.当 numbers[mid] == numbers[right] 时，无法判断最小值在哪个区间之中，此时让 right--，缩小区间范围，在下一轮进行判断
 * ·为什么是 right-- 缩小范围，而不是 left++？
 *      ·因为数组是升序的，所以最小值一定靠近左侧，而不是右侧
 *      ·比如，当存在 [1,2,2,2,2] 这种情况时，left = 0，right = 4，mid = 2，数值满足 numbers[mid] == numbers[right] 这个条件，如果 left++，则找不到最小值
 *
 */
public class MinArray {
    public static int minArray(int[] numbers){
        int left=0,right=numbers.length-1;
        while (left < right){
            int mid = (left+right)/2;
            if(numbers[mid] < numbers[right]){
                right = mid;
            }else if(numbers[mid] > numbers[right]){
                left = mid+1;
            }else
                right--;
        }
        return numbers[left];
    }

    public static int MyminArray(int[] numbers){
        for (int i=1;i<numbers.length-1;i++){
            if (numbers[i] < numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {

    }
}
