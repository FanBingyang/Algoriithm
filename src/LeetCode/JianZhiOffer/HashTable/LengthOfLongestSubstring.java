package LeetCode.JianZhiOffer.HashTable;

import java.util.*;

/**
 * @Author: FBY
 * @Date: 2021/4/18 11:21
 * @Version 1.0
 */

/**
 * 题目描述
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是、 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 提示: s.length <= 40000s.length<=40000
 *
 * 解题方案
 * 思路
 * ·标签：滑动窗口
 * ·整体思路：暴力解法时间复杂度较高，会达到 O(n^2)，故而采取滑动窗口的方法降低时间复杂度
 *
 * 复杂度：
 * 时间复杂度：O(n)。
 *
 * 算法流程
 * 1.定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 * 2.我们定义不重复子串的开始位置为 start，结束位置为 end
 * 3.随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 * 4.无论是否更新 start，都会更新其 map 数据结构和结果 ans。
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s){
        int n = s.length(),ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end=0,start=0; end<n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)){
                start = Math.max(map.get(alpha),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }


    /**
     * 思路：
     * ·遍历字符串，依次放入到Set集合中，当放入失败之后证明元素已经存在，比较当前长度与已有长度比较，保留最大值。
     * ·然后接着查找该元素在前半段字符串中最后一次出现的位置，找到之后更新索引，将当前集合清空，从该索引处继续上述步骤
     */
    public static int MylengthOfLongestSubstring(String s){
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        for (int i=0;i<s.length();i++){
            if (!charSet.add(s.charAt(i))){
                maxLength = maxLength>charSet.size()?maxLength:charSet.size();
                charSet.clear();
                i = s.substring(0,i).lastIndexOf(s.charAt(i));
            }
        }
        maxLength = maxLength>charSet.size()?maxLength:charSet.size();
        return maxLength;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
//        char c = ' ';
//        Set<Character> set = new HashSet<>();
//        set.add(c);
//        System.out.println(set.size());
    }
}
