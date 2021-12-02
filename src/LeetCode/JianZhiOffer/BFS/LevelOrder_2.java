package LeetCode.JianZhiOffer.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: FBY
 * @Date: 2021/4/23 15:47
 * @Version 1.0
 */

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 提示：
 * 节点总数 <= 1000
 */
public class LevelOrder_2 {

    /**
     * 思路
     * ·标签：树的广度遍历
     * ·通过广度遍历 BFS 可以进行每一层的节点值获取，通过队列的方式，将当前层节点的下一层子节点放入队列中，用于下一次循环取值，同时将本层的节点放入到本层数组中，当前层循环结束后塞入结果数组中
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     * 算法流程
     * 1.初始化队列 queue 和结果集 res
     * 2.当 root == null 时，直接返回空的结果集 res
     * 3.将 root 添加到 queue 中，用于下面的第一次循环
     * 4.当 queue 不为空时始终进行循环遍历，新建当前层结果集 level，并将 queue 中当前层的节点一一取出，将节点值添加到 level 中，如果节点存在左子树，则将左子树节点放入 queue 中，如果节点存在右子树，则将右子树节点放入 queue 中
     * 5.结束循环，返回结果集 res
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        if (root==null){
            return resList;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
