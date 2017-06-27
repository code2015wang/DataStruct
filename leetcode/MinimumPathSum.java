/*  给定一个m*n的数组，数组中元素为非负，找到一条从左上到右下的路径，使路径和最小*/
public class MinimumPathSum {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    grid[i][j] = grid[i][j];
                }
                else if (i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }
                else if (j == 0 && i != 0){
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }else{
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
