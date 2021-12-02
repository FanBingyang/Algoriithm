package LeetCode.JianZhiOffer.LinkedList;

import java.util.Stack;

/**
 * @Author: FBY
 * @Date: 2021/4/20 23:57
 * @Version 1.0
 */

/**
 * 题目描述
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 解题方案
 * 思路
 * ·标签：链表遍历
 * ·整体思路：通过前指针、当前指针和临时指针进行位置交换，从头部开始 2 个节点为一组进行倒序交换，直到遍历到链表结尾将链表反转完成
 * ·时间复杂度：O(n)，空间复杂度：O(1)
 * 算法流程
 * 1.初始化当前指针 cur = null，前指针 pre = head
 * 2.当 pre != null 时，说明还未到达链表结尾，则不断进行遍历交换
 * 3.tmp = pre.next，保存下一次要进行倒转的指针位置
 * 4.pre.next = cur，实现链表中 2 个节点的反转
 * 5.cur = pre，cur 指针后移一个位置
 * 6.pre = tmp，pre 指针后移一个位置
 * 7.进行下一轮的倒转，直到结束时最终的链表头结点为 cur，返回 cur 即可
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head){
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    /**
     * 思路：
     * ·借助栈来实现链表反转，先将链表指针依次入栈，然后依次出栈进行逆序连接
     */
    public static ListNode MyreverseList(ListNode head){
        if (head==null || head.next==null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode p = head;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            //我们虽然正向存入了栈中，但是每个节点的next的指向还没变，在这里要消除
            node.next = null;   //这一步关键（消除正向原本的指向关系）
            p.next = node;
            p = node;
        }
        return head;
    }
}
