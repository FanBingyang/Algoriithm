package LeetCode.JianZhiOffer.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第 k 个节点。为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 解题方案
 * 思路
 * ·标签：链表遍历
 * ·整体思路是使用双指针，间隔 k 个位置，同时向后移动，当前方指针移动到尾部时，后方指针的位置就是倒数第 k 个数字
 *      ·首先构建前指针 pre，后指针 post
 *      ·前指针 pre 向前移动 k 个位置
 *      ·前指针 pre 和后指针 post 同时向前移动，直到前指针为 null 时停止
 *      ·后指针 post 即为倒数第 k 个数字
 * ·时间复杂度：O(n)，空间复杂度：O(1)
 */
public class GetKthFromEnd {

    public static ListNode getKthFromEnd(ListNode head,int k){
        ListNode pre = head;
        ListNode post = head;
        // 先将前指针往前移k位
        for (int i=0;i<k;i++){
            pre = pre.next;
        }
        // 双指针同时后移
        while (pre!=null){
            pre = pre.next;
            post = post.next;
        }
        return post;
    }

    /**
     * 思路：
     * ·遍历链表，将链表指针与所处链表位置做映射，放入map中，然后直接可以找到倒数第k个指针
     */
    public static ListNode MygetKthFromEnd(ListNode head,int k){
        if (head==null)
            return null;
        Map<Integer,ListNode> map = new HashMap<>();
        int i=1;
        while (head!=null){
            map.put(i,head);
            head = head.next;
            i++;
        }
        return map.get(map.size()-k+1);

    }
}
