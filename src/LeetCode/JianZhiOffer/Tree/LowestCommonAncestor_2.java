package LeetCode.JianZhiOffer.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: FBY
 * @Date: 2021/4/26 23:16
 * @Version 1.0
 */

/**
 * 题目描述
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:root =[3,5,1,6,2,0,8,null,null,7,4]
 *      3
 *    /   \
 *   5      1
 *  / \    / \
 * 6   2  0   8
 *    / \
 *   7   4
 *
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * ·所有节点的值都是唯一的。
 * ·p、q 为不同节点且均存在于给定的二叉树中。
 *
 */
public class LowestCommonAncestor_2 {
    /**
     * 思路
     * ·标签：二叉树、DFS
     * ·整体思路：
     *      ·祖先节点定义：当前节点的父节点，其父节点的父节点，只要当前节点在某一个节点的子树下，则可以称其为当前节点的祖先节点
     *      ·公共祖先定义：p、q 节点都在某一个节点的子树下或者其自身，则可以称其为 p、q 节点的公共祖先节点
     *      ·最近公共祖先定义：从祖先节点的定义可以知道，如果 x 节点是 p、q 节点的公共祖先，那么 x 节点的祖先节点也一定是 p、q 节点的公共祖先，则距离 p、q 个节点深度最小的为最近公共祖先，通常表现为 p、q 节点不在最近公共祖先的同一个子树上
     *      ·根据题意可知，所有的节点值唯一，则可以根据 p、q 节点不在最近公共祖先的同一个子树上的特征，进行深度优先遍历，找到结果
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     * 算法流程
     * 1.终止条件：
     *  ·当 root 节点为 null 时，说明到达叶子节点的下一层，直接返回 null 即可
     *  ·当 root 节点为 p 或 q 时，说明找到了对应的节点，返回 root 即可
     * 2.递归内容：
     *  · 递归左子树 root.left，得到左子树返回值 left
     *  · 递归右子树 root.right，得到右子树返回值 right
     * 3.返回值：
     *  ·当 left 和 right 都为 null 时，说明当前层 root 的左右子树不包含 p、q 节点，返回 null 即可
     *  ·当 left 为 null 且 right 不为 null 时，说明当前层 root 的左子树不包含 p、q 节点，右子树包含 p、q 节点，则返回右子树 right
     *  ·当 left 不为 null 且 right 为 null 时，说明当前层 root 的左子树包含 p、q 节点，右子树不包含 p、q 节点，则返回左子树 left
     *  ·当 left 和 right 都不为 null 时，说明当前层 root 的左右子树均包含 p、q 节点，返回 root 即可
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left==null && right==null){
            return null;
        }else if (left==null && right!=null){
            return right;
        }else if (left!=null && right==null){
            return left;
        }else {
            return root;
        }
    }


    /**
     * 思路：
     * ·根据观察树的不同便利顺序的得出，在先序遍历中，两个节点的位置在前面的哪一个，它的所有的祖先都在他的前面。而在先序顺序中后面的哪一个节点，它在后序遍历中所有的祖先都在它的后面
     * ·由此可以先对树进行先序和后序遍历，将遍历结果保存在两个列表中，然后在先序遍历的列表中，找到两个节点的位置，然后进行比较，按照上面的匹配规则进行挨个对比，找到第一个相同的节点就是距离他们最近的公共父节点。
     *
     * 例如，给定如下二叉树:root =[3,5,1,6,2,0,8,null,null,7,4]
     *      3
     *    /   \
     *   5      1
     *  / \    / \
     * 6   2  0   8
     *    / \
     *   7   4
     * 先序：356274108
     * 中序：657243018
     * 后序：674250813
     */
    public TreeNode MylowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1= new ArrayList<>();
        List<TreeNode> list2= new ArrayList<>();
        flr(root,list1);
        lrf(root,list2);
        if (list1.indexOf(p) > list1.indexOf(q)){
            for (int i=list1.indexOf(q);i>=0;i--){
                for (int j=list2.indexOf(p);j< list2.size();j++){
                    if (list1.get(i)== list2.get(j)){
                        return list1.get(i);
                    }
                }
            }
        }else {
            for (int i=list1.indexOf(p);i>=0;i--){
                for (int j=list2.indexOf(q);j< list2.size();j++){
                    if (list1.get(i)== list2.get(j)){
                        return list1.get(i);
                    }
                }
            }
        }
        return root;
    }

    /* 先序遍历 */
    public static void flr(TreeNode root,List list){
        if (root!=null){
            list.add(root);
            flr(root.left,list);
            flr(root.right,list);
        }
    }
    /* 后序遍历 */
    public static void lrf(TreeNode root,List list){
        if (root!=null){
            lrf(root.left,list);
            lrf(root.right,list);
            list.add(root);
        }
    }

}
