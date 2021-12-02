package LeetCode.JianZhiOffer.ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/7 23:11
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 * 1 <= target <= 10^5
 *
 * 解题方案
 * 思路
 * ·标签：滑动窗口、指针
 * ·整体思路：
 *      ·最容易想到的思路就是暴力枚举，因为题目条件要求至少含有两个数，所以枚举到 target/2 即可停止，时间复杂度较高
 *      ·更好的方式是使用滑动窗口，设立左右指针，从开始位置维护一个子数组作为窗口，判断该窗口是否求和为 target，如果是则将结果加入，如果小于 target 则窗口右移，大于 target 则窗口左移
 * ·复杂度：
 *      ·时间复杂度：O(target)。滑动窗口最多移动 target/2 次
 *      ·空间复杂度：O(1)。排除必要的存储结果数组之外，只需要保存左右指针
 * 算法流程
 * 1.首先初始化窗口，left=1 和 right=2
 * 2.当 left < right 时始终维护该窗口，只有当到达边界位置时，窗口和 sum > target，left 始终右移，才会结束窗口维护
 * 3.根据求和公式 sum = (left + right) * (right - left + 1) / 2sum=(left+right)∗(right−left+1)/2 可以直接算出滑动窗口和
 * 4.当 sum == target 时，将窗口放入结果数组中
 * 5.当 sum < target 时，说明窗口结果需要变大，right++
 * 6.当 sum > target 时，说明窗口结果需要变小，left++
 */
public class FindContinuousSequence {

    public static int[][] findContinuousSequence(int target){
        int left=1,right=2;
        List<int[]> res = new ArrayList<>();

        while (left < right){
            // 因为需要的是连续的数字，所以可以直接用等差数列求和公式计算窗口内数字的和
            int sum = (left+right) * (right-left+1) / 2;
            if (sum == target){
                int[] arr = new int[right-left+1];
                for (int k=left;k<=right;k++){
                    arr[k-left] = k;
                }
                res.add(arr);
                left++;
            }
            else if (sum < target){
                right++;
            }
            else
                left++;
        }
        return res.toArray(new int[res.size()][]);

    }


    /**
     * 思路：
     * 从1开始到target/2进行枚举，作为起始数字，然后继续下一个数字开始累加，累加之后进行判断，如果当前累加和大于目标数，那么以当前起始数开始的序列不存在满足条件的序列，
     * 开始下一个数作为起始数继续上述操作。如果累加和等于目标数，则新建数组，数组长度是最后一个数减第一个数加1得出，然后循环将起始数到最后一个数放进数组内，等到一个满足条件的序列。
     *
     * 因为要求返回二维数组，而二维数组的长度是不确定的，内部的每一个一维数组的长度也是不确定的，所以每次初始化是一个List，然后每次得到满足条件的序列需要创建新得数组，将数组放进List中，最后返回时将List转换成二维数组即可。
     *
     */
    public static int[][] MyfindContinuousSequence(int target){
        List<int[]> res = new ArrayList<>();
        for (int i=1;i<=target/2;i++){
            int sum = i;
            for (int j=i+1;j<target;j++){
                sum += j;
                if (sum > target)
                    break;
                else if (sum == target){
                    // 每一组序列的数字长度是最后一个数减第一个数加1得出
                    int[] arr = new int[j-i+1];
                    for (int k=i,l=0;k<=j;k++,l++){
                        arr[l] = k;
                    }
                    res.add(arr);
                    break;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[][] res = MyfindContinuousSequence(target);
        for (int i=0;i< res.length;i++) {
            // 不确定一维数组长度是不是都相同，所以每次长度取得是当前数组得长度
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
