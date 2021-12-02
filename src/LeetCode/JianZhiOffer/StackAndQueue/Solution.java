package LeetCode.JianZhiOffer.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: FBY
 * @Date: 2021/4/17 17:25
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例 1:
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2:
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 限制：
 * 1.0 <= pushed.length == popped.length <= 1000
 * 2.0 <= pushed[i], popped[i] < 1000
 * 3.pushed是 popped 的排列。
 * 解题方案
 * 思路
 * ·标签：模拟
 * ·整体思路：
 * 借用一个辅助栈 stack，模拟 压入/弹出操作的排列。根据是否模拟成功，即可得到结果。
 * ·复杂度：
 *      ·时间复杂度：O(n)。 nn 为入栈序列的长度
 *      ·空间复杂度：O(n)： 辅助栈最多存储 nn 个元素
 * 算法流程
 * 1.建立一个辅助栈
 * 2.遍历入栈序列
 *  ·元素入栈
 *  ·若辅助栈栈顶元素等于弹出序列元素，则执行出栈操作
 * 3.返回结果
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int element : pushed) {
            stack.push(element); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean MyvalidateStackSequences(int[] pushed, int[] popped) {
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i=0;i<pushed.length;){
            // 比较当前要入栈的值与要出栈的值是否相同，相同的话就两个指针同时往后移一个，减少了一次元素入栈在出栈的操作
            if (pushed[i] == popped[j]){
                j++;
                i++;
            }
            // 当前栈不为空且比较当前栈顶元素与要出栈的值是否相同，相同就元素出栈，要出栈的指针后移一个
            else if (!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
            // 如果要出栈的元素与要入栈的元素以及栈顶元素都不相同，则元素入栈，要入栈指针后移一个
            else {
                stack.push(pushed[i]);
                i++;
            }
        }
        // 比较剩余站内元素与要出栈的顺序
        while (!stack.isEmpty() && j< popped.length){
            // 弹出栈顶元素，如果栈顶元素与要出栈的元素不相同，则返回false
            if (stack.pop()!= popped[j]){
                flag=false;
                break;
            }
            // 否则要出栈的指针后移一个
            else {
                j++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        boolean flag = MyvalidateStackSequences(pushed,popped);
        System.out.println(flag);
    }
}
