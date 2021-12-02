package LeetCode.JianZhiOffer.DFS;

/**
 * @Author: FBY
 * @Date: 2021/4/21 15:29
 * @Version 1.0
 */

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串 “bfce” 的路径（路径中的字母用数字标出）。
 *
 * [["a","b1","c","e"],
 * ["s","f2","c3","s"],
 * ["a","d","e4","e"]]
 *
 * 但矩阵中不包含字符串 “abfb” 的路径，因为字符串的第一个字符 b 占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1:
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2:
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Exist {

    /**
     * 思路
     * ·标签：深度优先搜索
     * ·整体思路：
     *      ·题目可以模拟为 DFS 的过程，即从一个方向搜索到底，再回溯上一个节点，沿另一个方向继续搜索，递归进行。在搜索过程中，若遇到该路径不可能与目标字符串匹配的情况，执行剪枝，立即返回。
     * ·复杂度：
     *      ·时间复杂度：O(3^k IJ)。 一次搜索完全部矩阵的时间复杂度为 O(IJ)O(IJ) ，共需要 3^k次搜索
     * 空间复杂度：搜索过程中的递归深度不超过 KK ，因此系统因函数调用累计使用的栈空间占用 O(K)O(K)
     * 算法流程
     * 1.递推参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     * 2.终止条件：
     *      ·行或列索引越界 或 当前矩阵元素与目标字符不同 或 当前矩阵元素已访问过，返回 false
     *      ·目标字符串全部匹配成功，返回 true
     * 3.   ·将当前元素值暂存在 tmp 中，修改为字符 ‘/’，以此标记为该元素已访问。通过 tmp 变量存值可以免去新建一个访问过的字符串数组，节省空间。
     *      ·向其他方向继续搜索， 并记录结果， 遇 false 即返回
     *      ·将 tmp 值还原到当前元素
     * 4.返回结果
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i< board.length;i++)
            for (int j=0;j<board[0].length;j++)
                if (dfs(board,words,i,j,0))
                    return true;
        return false;
    }

    public static boolean dfs(char[][] board,char[] word,int i,int j,int k){
        if (i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!=word[k])
            return false;
        if (k == word.length-1)
            return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean result = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1) || dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1);
        board[i][j] = temp;
        return result;
    }
}
