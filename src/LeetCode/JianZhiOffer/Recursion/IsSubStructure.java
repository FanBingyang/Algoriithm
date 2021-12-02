package LeetCode.JianZhiOffer.Recursion;

/**
 * @Author: FBY
 * @Date: 2021/4/28 14:32
 * @Version 1.0
 */

/**
 * 题目描述
 * 输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。(约定空树不是任意一个树的子结构)
 * B 是 A 的子结构， 即 A 中有出现和 B 相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *    3
 *   / \
 *   4  5
 *  / \
 * 1  2
 *
 * 给定的树 B：
 *   4
 *  /
 * 1
 *
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 * 0 <= 节点个数 <= 10000
 */
public class IsSubStructure {
    /**
     * 思路
     * ·标签：递归
     * ·整体思路：
     *      ·子树：若 B 是 A 的子树，则 A 包含 B 的所有结点，并且 B 的叶子节点一定是A的叶子节点。 也就是 A 只要包含了 B 的一个结点，就得包含这个结点下的所有节点。
     *      ·子结构：若 B 是 A 的子结构，则 A 包含 B 的所有结点，但 B 的叶子节点不一定是 A 的叶子节点。也就是子结构 B 是 A 树的任意一部分。
     *      ·此题目是 子结构相关。此题目约定空树，不为任何一棵树的子结构。如果 B 为 A 的子结构，则B的根节点一定是A的任意一个节点。
     *      ·双重递归。
     * ·复杂度：
     *      ·时间复杂度 O(mn)，m 和 n 为树 A 和 B 的节点数量。
     *      ·空间复杂度 O(m)，m 是树 A 的递归深度。
     * 算法流程
     * 1.双重递归第一重，isSubStructure
     *  ·判断 B 是否为 A 的子结构 (约定空树,不为任何一棵树的子结构)
     *  ·约定空树不是任意一个树的子结构. 所以 A 不可为空树,且 B 不可为空树。
     *  ·B 是以 "A 为根节点" 的子结构,或者 B 是 "A 的左子树" 的子结构,或者B是 "A 的右子树" 的子结构。注意三者为 或 的关系
     *  ·相当于对 A 进行了前序遍历: 根->左->右
     * 2.双重递归第二重，isInclude
     *  ·判断 root1 是否包含 root2 (从集合关系分析,空集属于任何集合的子集)
     *  ·pRoot2 为空,则 root1 包含 root2
     *  ·root1 为空,则 root1 不包含 root2
     *  ·root1，root2 都不为空, 但节点值不同，则 root1 不包含 root2，即不具备包含关系
     *  ·如果值相同，则判断他们的左右节点是否也是包含关系（必须都是包含关系才行）
     *  ·递归判断 A 的左节点和 B 的左节点是否相等, 递归判断 A 的右节点和 B 的右节点是否相等
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null)
            return false;
        return isInclude(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public static boolean isInclude(TreeNode root1,TreeNode root2){
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isInclude(root1.left, root2.left) && isInclude(root1.right, root2.right);
    }
}
