package LeetCode.JianZhiOffer.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: FBY
 * @Date: 2021/4/9 14:46
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 解题方案
 * 思路
 * ·标签：栈
 * ·栈的特点是先进后出，因为题目要求从尾到头打印元素，所以符合栈的特性
 *      ·先遍历一遍链表，将链表中的元素存入到栈中
 *      ·再不断弹出栈内元素，将弹出元素存放到结果数组中
 * ·也有使用递归来进行解题的，在此提出一个思考，递归和栈的关系是什么？其实递归的本质也是在使用栈，只不过是程序调用栈，因为没有显式在代码中体现出来，所以常常被忽略了
 * ·时间复杂度：O(n)，空间复杂度：O(n)
 *
 */

/**
 * 链表结构
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){
        val  = -1;
        next = null;
    }
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class ReversePrint {

    public static int[] reversePrint(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode pointer = head;
        while (pointer != null){
            stack.push(pointer);
            pointer = pointer.next;
        }
        int length = stack.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 初始化链表
        ListNode head = new ListNode();
        // 头插法
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            ListNode node = new ListNode(t);
            node.next = head.next;
            head.next = node;
        }
        int[] arr = reversePrint(head);
        for (int i = 0; i < arr.length-1; i++) {
            System.out.println(arr[i]);
        }
    }
}
