package LeetCode.JianZhiOffer.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: FBY
 * @Date: 2021/4/22 17:52
 * @Version 1.0
 */

/**
 * 题目描述
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 */
public class IsSymmetric {
    /**
     * 解题方案
     * 思路
     * ·标签：dfs
     * ·递归结束条件：
     *      ·都为空指针则返回 true
     *      ·只有一个为空则返回 false
     * ·递归过程：
     *      ·判断两个指针当前节点值是否相等
     *      ·判断 A 的右子树与 B 的左子树是否对称
     *      ·判断 A 的左子树与 B 的右子树是否对称
     * ·短路：在递归判断过程中存在短路现象，也就是做与操作时，如果前面的值返回 false 则后面的不再进行计算
     * ·时间复杂度：O(n)
     *
     */
    public static boolean isSymmetric(TreeNode root){
        return isMirror(root,root);
    }

    public static boolean isMirror(TreeNode lTree,TreeNode rTree){
        if (lTree==null && rTree==null)
            return true;
        if (lTree==null || rTree==null)
            return false;
        return (lTree.val == rTree.val) && isMirror(lTree.left,rTree.right) && isMirror(lTree.right,rTree.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        System.out.println(isSymmetric(root));
    }
}
