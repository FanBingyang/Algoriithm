package LeetCode.Code;

/**
 * @Author: FBY
 * @Date: 2021/4/6 10:59
 * @Version 1.0
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid,int S){
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
//                    islands++;
//                    dfs(grid,i,j);
                    if (dfs(grid,i,j) == S){
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    public static int dfs(char[][] grid, int i, int j){
        int sum = 0;
        if(i<0 || i== grid.length || j<0 || j==grid[0].length)
            return sum;
        if (grid[i][j] == '1'){
            grid[i][j] = '2';
            sum++;
            sum += dfs(grid, i-1, j);
            sum += dfs(grid, i+1, j);
            sum += dfs(grid, i, j-1);
            sum += dfs(grid, i, j+1);
        }
        return sum;
    }

//    public static void dfs(char[][] grid, int i, int j){
//        if(i<0 || i== grid.length || j<0 || j==grid[0].length)
//            return;
//        if (grid[i][j] == '1'){
//            grid[i][j] = '2';
//            dfs(grid, i-1, j);
//            dfs(grid, i+1, j);
//            dfs(grid, i, j-1);
//            dfs(grid, i, j+1);
//        }
//    }

    public static void main(String[] args) {
        char[][]  grid= {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
//        char[][]  grid= {
//                {'0','1','0','1','1'},
//                {'1','1','1','0','0'},
//                {'1','1','0','0','1'},
//                {'0','1','0','1','1'}};
        int S = 8;
        int num = numIslands(grid,S);
        System.out.println(num);
    }
}
