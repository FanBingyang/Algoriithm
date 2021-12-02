package LeetCode.JianZhiOffer.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: FBY
 * @Date: 2021/4/23 10:31
 * @Version 1.0
 */

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class KthLargest {
    private static int res,curK;

    /**
     *思路
     * ·标签：树的深度遍历
     * ·整体思路：二叉搜索树按照中序遍历（左、中、右）可以获得升序数字，题目要找到第 k 大的节点，所以需要数字降序排列，则将中序遍历按照右、中、左遍历即可，遍历的同时找到第 k 个遍历到的值
     * ·时间复杂度：O(n)，空间复杂度：O(1)
     * ·算法流程
     * 1，初始化全局变量 curK = k，用于之后计数
     * 2，进行树的右、中、左深度遍历
     *      ·终止条件：root 节点为 null
     *      ·右子树进行递归遍历
     *      ·curK 自减一，用于计数，当 curK 为 0 时表示找到第 k 大的节点，则可以结束
     *      ·左子树进行递归遍历
     *
     */
    public static int kthLargest(TreeNode root,int k){
        curK = k;
        dfs(root);
        return res;

    }

    public static void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.right);
        if (curK==0){
            return;
        }
        curK--;
        if (curK==0){
            res = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        root.left = t1;
        t1.right = t3;
        root.right = t2;
        t2.right = t4;
        System.out.println(kthLargest(root,1));
    }

}
