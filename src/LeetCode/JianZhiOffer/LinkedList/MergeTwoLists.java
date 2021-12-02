package LeetCode.JianZhiOffer.LinkedList;

/**
 * @Author: FBY
 * @Date: 2021/4/21 0:22
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例 1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 解题方案
 * 思路
 * ·标签：链表、递归
 * ·这道题可以使用递归实现，新链表也不需要构造新节点
 * ·终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
 * ·返回值：每一层调用都返回排序好的链表头
 * ·本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
 * ·O(m+n)，m 为 l1 的长度，n 为 l2 的长度
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 思路：
     * ·先做为空判断，如果一个为空那么就返回另一个。
     * ·如果两个都不为空，首先进行第一个节点值的判断，最小的作为头节点，并且该链表指针后移。
     * ·创建指针节点，依次判断节点值的大小，值小的就作为当前节点连接到指针节点后面，并且该链表指针后移。
     * ·只有一个链表为空了，退出循环，将不为空的表连接在指针节点后面。返回头节点。
     */
    public static ListNode MymergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode head;
        if (l1.val<=l2.val){
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 =l2.next;
        }
        ListNode p = head;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                p = l2;
                l2 =l2.next;
            }
        }
        if (l1!=null)
            p.next = l1;
        if (l2!=null)
            p.next = l2;
        return head;

    }
}
