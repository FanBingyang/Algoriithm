package LeetCode.JianZhiOffer.LinkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: FBY
 * @Date: 2021/4/21 10:07
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共节点。
 * 如下面的两个链表：
 * A:       a1 -> a2 ↘
 *                    c1 -> c2 -> c3
 * B: b1 -> b2 -> b3 ↗
 * 在节点 c1 开始相交。
 *
 * 示例 1：
 * A:       4 -> 1 ↘
 *                   8  -> 4 -> 5
 * B:  5 -> 0 -> 1 ↗
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2：
 * A: 0 -> 9 -> 1 ↘
 *                  2 -> 4
 * B:           3 ↗
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例 3：
 * A: 2 -> 6 -> 4
 * B:  1 -> 5
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * 注意：
 * ·如果两个链表没有交点，返回 null。
 * ·在返回结果后，两个链表仍须保持原有的结构。
 * ·可假定整个链表结构中没有循环。
 * ·程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {

    /**
     * 思路
     * ·标签：双指针链表遍历
     * ·分别构造 2 个指针去遍历 2 个链表，无论哪个指针到尾部时，让其重新回到对方的头部，最终会在第一个公共节点相遇，
     *  这是因为两个指针走的距离是一样的，A的指针走过了A的全程加上B的非公共部分，B的指针走过了B的全程加上了A的非公共部分。如果没有，则A、B指针把两个链表各遍历一边过后会在 null 处相遇
     * ·时间复杂度：设 A 链表非公共长度为 m，B 链表非公共长度为 n，公共部分为 b，则复杂度为 O(m+n+b)，空间复杂度：O(1)
     * 算法流程
     * 1.使用 headA 和 headB 初始化 2 个指针 curA 和 curB，用来遍历使用
     * 2.进行循环遍历，直到 curA 和 curB 相同时结束
     * 3.遍历过程中如果 curA 到尾部则将其重新放回头部 headB，如果 curB 到尾部则将其重新放回头部 headA
     * 4.循环结束时在第一个公共节点相遇，返回该节点 curA
     *
     */
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=curB){
            curA = curA!=null ? curA.next : curB;
            curB = curB!=null ? curB.next : curA;
        }
        return curA;
    }

    /**
     * 思路：
     * ·两个链表公共节点之后的所有节点都一样，如果从尾节点开始倒序比较，那么出现节点不一致的时候，他的上一个节点就是第一个公共节点
     * ·可以使用两个栈进行辅助，先把两个链表依次遍历入栈
     * ·然后如果两个栈都不为空，并且栈顶元素相等，那么就用临时节点存储这个元素，然后两个栈都弹出栈顶元素
     * ·最后返回临时节点
     * 时间复杂度：设 A 链表长度为 m，B 链表长度为 n，则复杂度为 O(m+n)，空间复杂度：O(m+n)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode_2(ListNode headA,ListNode headB){
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA!=null){
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB!=null){
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() &&stackA.peek()==stackB.peek()){
            res = stackA.pop();
            stackB.pop();
        }
        return res;

    }

    /**
     * 思路：
     * ·先计算出两个列表的长度，然后计算出长度差n，短的链表先往后遍历n个节点，这样两个链表的头结点到第一个公共节点的距离是相等的
     * ·同时往后遍历两个链表，节点相同则返回
     */
    public static ListNode getIntersectionNode_３(ListNode headA,ListNode headB){
        int aLength = 0,bLength=0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=null){
            aLength++;
            curA = curA.next;
        }
        while (curB!=null){
            bLength++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (aLength-bLength>0){
            for (int i=0;i<aLength-bLength;i++)
                curA = curA.next;
        }else for (int i=0;i<bLength-aLength;i++)
            curB = curB.next;
        while (curA!=null && curB!=null){
            if (curA!=curB) {
                curA = curA.next;
                curB = curB.next;
            }
            else return curA;
        }
        return null;
    }



    /**
     * 思路：
     * ·如果两个列表有公共节点，那么他们从公共节点开始，在这之后的节点都相同
     * ·首先遍历其中一个链表，将所有节点都放在集合里。
     * ·然后遍历另外一个列表，依次判断当前节点有没有在集合中，如果在，那么就返回。
     */
    public static ListNode MygetIntersectionNode(ListNode headA,ListNode headB){
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }



}
