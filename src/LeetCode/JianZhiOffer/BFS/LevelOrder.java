package LeetCode.JianZhiOffer.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: FBY
 * @Date: 2021/4/23 13:14
 * @Version 1.0
 */

/**
 * 题目描述
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 *
 * 提示：
 * 节点总数 <= 1000
 */
public class LevelOrder {

    /**
     * 思路
     * ·标签：树的广度遍历
     * ·整体思路：广度遍历的最常见思路，使用队列按层次存储，然后依次取出，达到按层次进行遍历的效果
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     * 算法流程
     * 1.判断 root 是否为 null，如果为 null 则直接返回空数组
     * 2.初始化队列，并将初始的 root 节点加入队列之中
     * 3.当队列不为空时不断广度遍历二叉树，遍历时依次从队列中取出节点，取出后如果该节点存在左节点则将左节点放入队列中，如果该节点存在右节点则将右节点放入队列中
     * 4.在遍历过程中存储结果，最后将结果按照要求的格式返回
     */
    public int[] levelOrder(TreeNode root){
        if (root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();;
            list.add(temp.val);
            if (temp.left!=null){
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                queue.offer(temp.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
