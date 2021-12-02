package LeetCode.JianZhiOffer.Recursion;

import java.util.HashMap;

/**
 * @Author: FBY
 * @Date: 2021/4/27 20:09
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 示例 1:
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class BuildTree {
    public static HashMap<Integer,Integer> midMap = new HashMap<>();
    public static int[] preOrder;

    /**
     * 思路
     * ·标签：递归
     * ·整体思路：
     *      ·根据二叉树的遍历特点可知：前序遍历首个元素为根节点；在中序遍历中可由根节点位置将其分为‘左子树’‘根节点’‘右子树’；在中序遍历中可知左右子树的节点数量。因此可以确定三个节点关系，根据树的特点，我们很自然的可以使用递归方法。
     * ·复杂度：
     *      ·时间复杂度：O(n)。 n 为树的节点数量。初始化 HashMap 需遍历 inOrder ，占用 O(n) ；递归占用 O(n) 。（最差情况为所有子树只有左节点，树转化为链表，此时递归深度 O(n) ；平均情况下递归深度 O(logn)
     *      ·空间复杂度：O(n)。HashMap 使用 O(n) 额外空间；递归操作需使用 O(n) 额外空间。
     * 算法流程
     * 1.递推参数： 前序遍历中根节点的索引 preRoot、中序遍历左边界 inLeft、中序遍历右边界 inRight。
     * 2.终止条件： 当 inLeft > inRight ，子树中序遍历为空，说明已经越过叶子节点，此时返回 null 。当 inLeft = inRight 时， 代表只有该节点本身。
     * 3.
     *  ·由先序遍历中确定根节点 root
     *  ·左子树的根节点就是 左子树的（前序遍历）第一个，就是+1,左边边界就是 inLeft，右边边界是中间区分的根节点在中序中的索引 -1
     *  ·右子树的根，是右子树（前序遍历）的第一个，也就是当前根节点 加上左子树的数量
     * 4.返回 root
     */
    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        this.preOrder = preOrder;
        // 为了提升搜索效率，使用哈希表存储中序遍历的值与索引的映射关系
        for (int i = 0; i < preOrder.length; i++) {
            midMap.put(inOrder[i],i);
        }
        return build(0,0,inOrder.length-1);
    }

    public static TreeNode build(int preRoot,int inLeft,int inRight){
        // 终止条件
        if (inLeft>inRight)
            return null;
        // 构建根节点
        TreeNode root = new TreeNode(preOrder[preRoot]);

        // 在中序map中获取根节点的索引
        int inRootIndex = midMap.get(preOrder[preRoot]);
        root.left = build(preRoot+1,inLeft,inRootIndex-1);
        root.right = build(preRoot+(inRootIndex-1-inLeft+1)+1,inRootIndex+1,inRight);
        return root;
    }
}
