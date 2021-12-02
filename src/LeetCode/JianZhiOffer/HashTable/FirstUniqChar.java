package LeetCode.JianZhiOffer.HashTable;

import java.util.*;

/**
 * @Author: FBY
 * @Date: 2021/4/19 17:20
 * @Version 1.0
 */

/**
 * 题目描述
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * s只包含小写字母。
 *
 * 示例1：
 * s = "abaccdeff"
 * 返回 "b"
 *
 * 示例2：
 * s = ""
 * 返回 " "
 *
 * 限制：
 * 0 <= s 的长度 <= 50000
 *
 * 解题方案
 * 思路
 * ·标签：哈希
 * ·首先遍历字符串将每个字符串映射到固定的位置，并且该位置存储字符串的出现次数，然后再遍历一次字符串，找到第一个只出现一次的字符
 * ·时间复杂度：O(n)，空间复杂度：O(1)
 * 算法流程
 * 1.初始化哈希表 map，大小为 26，因为只有 26 个小写字符
 * 2.遍历字符串 s，将遍历到的单个字符与 'a' 做减法，作为下标映射到哈希表中，比如 'b' - 'a' = 1，则位置为 map[1]
 * 3.再次遍历字符串 s，当出现次数为 1 的时候，返回该字符
 */
public class FirstUniqChar {

    public static char firstUniqChar(String s){
        int[] map = new int[26];
        for (char ch:s.toCharArray()){
            map[ch-'a']++;
        }
        for (char ch:s.toCharArray()){
            if (map[ch-'a']==1){
                return ch;
            }
        }
        return ' ';
    }


    /**
     * 思路：
     * ·遍历字符串，将遍历出来的每个字符放在一个Map里，注意：这里的Map一定要是LinkedHashMap，因为HashMap类型不是按插入顺序存放的，而是会自动排序，这样就会出错。
     * ·取出字符之后，判断当前map中始否存在这个键，如果没有，那么就将该字符存入，对应的值是出现的次数，默认是1，如果当前map存在该键，那么对应的值加一。直到将字符串遍历完成
     * ·之后开始遍历map的键，判断键对应的值是否等于1，如果等于1，该键就是第一个出现1次的字符，返回即可。
     */
    public static char MyfirstUniqChar(String s){
        if (s.length()==0 || s==null)
            return ' ';
        // 一定要初始化为LinkedHashMap!!!因为HashMap类型是不按插入顺序存放的，这样就会出错。 比如说：“leetcode”，使用HashMap的话最终结果就不会是“l”而是“c".
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else
                map.put(c,1);
        }

        for (Character key:map.keySet()){
            if (map.get(key)==1){
                return key;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

    }
}
