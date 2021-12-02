package LeetCode.JianZhiOffer.DFS;

/**
 * @Author: FBY
 * @Date: 2021/4/23 11:26
 * @Version 1.0
 */
public class DaxDepth {
    public static int maxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
