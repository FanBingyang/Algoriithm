package LeetCode.Code;

import java.util.*;

/**
 * @Author: FBY
 * @Date: 2021/4/17 0:10
 * @Version 1.0
 */

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 */
public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums,int k){
        // 存储
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // 创建最小堆
        PriorityQueue<Integer> minQueue =  new PriorityQueue<Integer>((o1,o2)->(
                map.get(o1)==map.get(o2)?o2-o1:map.get(o1)-map.get(o2)
                ));

        //最小堆添加数据,(已经从小到大排序)  利用hashmap去除重复的key
        for (int num:map.keySet()) {
            minQueue.add(num);
            // 如果size超过K,弹出堆首的数,因为最后要返回size=k的list
            if (minQueue.size()>k){
                minQueue.poll();
            }
        }

        //为list赋值
        List<Integer> list = new ArrayList<>();
        while ((!minQueue.isEmpty())){
            list.add(minQueue.poll());
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        List<Integer> list = topKFrequent(nums,k);
        for (int num:list) {
            System.out.println(num);
        }
    }

}
