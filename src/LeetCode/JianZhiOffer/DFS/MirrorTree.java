package LeetCode.JianZhiOffer.DFS;

/**
 * @Author: FBY
 * @Date: 2021/4/22 17:34
 * @Version 1.0
 */

/**
 * 题目描述
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *     4
 *    /  \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 镜像输出：
 *     4
 *    /  \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 */
public class MirrorTree {

    /**
     * 思路：
     * ·当根节点为空且或者左右子树都为空的情况下，返回根节点
     * ·否则，对左子树进行递归处理，对右子树进行递归处理
     * ·然后交换左右子树节点，返回根节点
     */
    public static TreeNode MymirrorTree(TreeNode root){
        if (root==null || (root.left==null && root.right==null)){
            return root;
        }
        MymirrorTree(root.left);
        MymirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    /**
     * 思路
     * ·标签：dfs
     * ·递归结束条件：
     *      ·当节点 root 为 null 时，说明已经到叶子节点了，递归结束
     * ·递归过程：
     *      ·初始化当前节点，并且赋值
     *      ·递归原来树的右子树 mirrorTree(root.right)，并将该结果挂到当前节点的左子树上
     *      ·递归原来树的左子树 mirrorTree(root.left)，并将该结果挂到当前节点的右子树上
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     *
     */
    public static TreeNode mirrorTree(TreeNode root){
        TreeNode res = null;
        if (root!=null){
            res = new TreeNode(root.val);
            res.left = mirrorTree(root.right);
            res.right = mirrorTree(root.left);
        }
        return res;
    }


}
