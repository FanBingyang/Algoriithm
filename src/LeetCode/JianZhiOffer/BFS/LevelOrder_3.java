package LeetCode.JianZhiOffer.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: FBY
 * @Date: 2021/4/23 16:28
 * @Version 1.0
 */

/**
 * 题目描述
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 提示：
 * 节点总数 <= 1000
 */
public class LevelOrder_3 {
    /**
     * 思路
     * ·标签：双端队列、树的广度遍历
     * ·整体思路：从 root 节点开始，每次取下一层的所有节点放入队列中，放入队列时如果层数为奇数，则依次放到当前层结果的尾部，达到从左到右的顺序打印效果。如果层数为偶数，则依次放到当前层结果的头部，达到从右向左的顺序打印效果。
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     * 算法流程
     * 1.初始化结果集合 res，如果 root == null 则直接返回空的结果集
     * 2.初始化队列 queue，并将 root 添加到队列中
     * 3.当队列不为空时，将当前 queue 中的所有值取出，构造每一层的结果 list
     * 4.如果层数为奇数层，则进行尾插法，将结果按顺序在 list 尾部进行插入
     * 5.如果层数为偶数层，则进行头插法，将结果按顺序在 list 头部进行插入
     * 6.将当前层结果 list 加入到 res 中，最后返回 res
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root==null){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer>  list = new LinkedList<>();
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode temp = queue.poll();
                // 因为每一层的数据会存放在一个list里放到最终返回的数据集里，所以最终返回的数据集里的元素个数，就是代表了当前的层数。
                if (resList.size() % 2 ==0){
                    list.addLast(temp.val);
                }else {
                    list.addFirst(temp.val);
                }
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        List<List<Integer>> list = levelOrder(root);
        for (List<Integer> l: list) {
            for (Integer i:l ) {
                System.out.printf(i+" ");
            }
            System.out.println();
        }
    }
}
