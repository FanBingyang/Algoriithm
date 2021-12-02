package LeetCode.JianZhiOffer.StackAndQueue;

import java.util.*;

/**
 * @Author: FBY
 * @Date: 2021/4/17 18:17
 * @Version 1.0
 */

/**
 * 题目描述
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 *
 * 解题方案
 * 思路
 * ·标签：单调队列
 * ·整体思路：
 *      ·从题目上来看是通过维护滑动窗口，然后每次求滑动窗口中的最大值即可，设数组长度为 n，窗口长度为 k，则时间复杂度为 O(k*(n-k+1)) = O(kn)
 *      ·很显然使用暴力解法的话，时间复杂度会随着 k 变大不断变大，而其中有很多元素在不同的滑动窗口中都存在着，所以必然存在重复计算的逻辑
 *      ·考虑使用单调队列，队列内只存在窗口内的元素，队列内元素递减。可以保证所有的数据只会入队和出队一次，减少时间复杂度
 * ·复杂度：
 *      ·时间复杂度：O(n)。遍历数组需要 O(n) 的时间复杂度，数组中的元素最多入队和出队一次，队列内元素维护最多需要 O(2n) ，所以总体时间复杂度为 O(n)
 *      ·空间复杂度：O(k)。维护一个最多元素个数为 k 个的队列
 * 算法流程
 * 1.初始化滑动窗口的 left 和 right 位置，从下标为 [1-k, 0] 范围开始
 * 2.如果 left > 0 说明窗口已经在数组中了，并且单调队列的第一个元素和 nums[left - 1] 相等时，说明该元素已经不在滑动窗口中，需要移除
 * 3.如果单调队列不为空且最后一个元素小于新加入的 nums[right] 元素，则需要维护单调队列为递减状态，所以将最后一个元素移除，直到其大于新加入元素
 * 4.将新加入的 nums[right] 元素加入单调队列，因为上一步的操作，当前单调队列一定是递减的
 * 5. left >= 0，说明窗口在数组中，因为单调队列递减，所以第一个元素一定是当前滑动窗口最大值
 *
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int right = 0, left = 1 - k; right < nums.length; left++, right++) {
            if(left > 0 && queue.peekFirst() == nums[left - 1]) {
                queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast() < nums[right]) {
                queue.removeLast();
            }
            queue.addLast(nums[right]);
            if(left >= 0) {
                res[left] = queue.peekFirst();
            }
        }
        return res;
    }

    /**
     * 思路：
     * ·先找出第一个窗口中的最大值，存储之后，窗口后移，后移的时候判断上一个窗口的最大值是否还在当前窗口，如果在，就用这个最大值与窗口最后一个(也就是刚进入窗口)的元素进行比较，得出最大值，如果上一个窗口的最大值不在当前窗口那么重新获取当前窗口的最大值进行存储。
     * · 也可以用List代替数组，但是效率不如数组
     * 算法流程
     * 1，数组长度为0或者窗口长度大于数组长度或者窗口长度为0，直接返回空数组
     * 2，先求出第一个窗口的最大值，进行存储
     * 3，遍历数组，对窗口进行滑动，窗口后移的过程中判断上一个窗口的最大值是否还在当前窗口中
     * 4，如果在，就与新加入窗口的元素进行比较，得出最大值。如果不在，重新获取当前窗口的最大值。
     * 5，窗口滑动到最后，返回结果
     */
    public static int[] MymaxSlidingWindow(int[] nums, int k) {
        if (nums.length==0 || nums.length<k || k==0){
            return new int[]{};
        }
        int maxOfIndex = findMaxOfIndex(nums,0,k-1);
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(nums[maxOfIndex]);
        int[] res = new int[nums.length-k+1];
        res[0] = nums[maxOfIndex];
        for (int i=1;i< nums.length-k+1;i++){
            if (i<=maxOfIndex){
                maxOfIndex = nums[maxOfIndex]>nums[i+k-1]?maxOfIndex:i+k-1;
//                list.add(nums[maxOfIndex]);
                res[i] = nums[maxOfIndex];
            }else {
                maxOfIndex = findMaxOfIndex(nums,i,i+k-1);
//                list.add(nums[maxOfIndex]);
                res[i] = nums[maxOfIndex];
            }
        }
        // 把List<Integer>列表转成int[]数组
//        return list.stream().mapToInt(i -> i).toArray();
        return res;
    }

    /*
     * 找出一个数组值定部分中最大值的角标
     */
    public static int findMaxOfIndex(int[] nums,int start,int end){
        int maxOfIndex = start;
        for (int i=start+1;i<=end;i++){
            maxOfIndex = nums[maxOfIndex]>nums[i]?maxOfIndex:i;
        }
        return maxOfIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        for (int num:MymaxSlidingWindow(nums,k)) {
            System.out.println(num);
        }

    }
}
