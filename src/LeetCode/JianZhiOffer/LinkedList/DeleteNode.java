package LeetCode.JianZhiOffer.LinkedList;

/**
 * @Author: FBY
 * @Date: 2021/4/20 20:37
 * @Version 1.0
 */

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。

 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

 * 说明：
 * 题目保证链表中节点的值互不相同
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head,int val){
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode post = head;
        ListNode pre = head.next;
        while (pre!=null && pre.val!=val){
            post = pre;
            pre = pre.next;
        }
        if (pre != null){
            post.next = pre.next;
        }
        return head;
    }
}
